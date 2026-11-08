package com.app.redis.cache;

import com.app.redis.config.CacheNames;
import com.app.redis.model.DepartmentResponse;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Objects;

@Slf4j
@Component
public class DepartmentCache {

  private final Cache cache;

  public DepartmentCache(CacheManager cacheManager) {
    this.cache = Objects.requireNonNull(cacheManager.getCache(CacheNames.DEPARTMENTS), "Cache ' " + CacheNames.DEPARTMENTS + "' is not configured");
  }

  // A cache hit. {@code department == null} means "known to not exist"
  public record Entry(@Nullable DepartmentResponse department) {
  }


  @Nullable
  public Entry lookUp(Long deptId) {
    Cache.ValueWrapper valueWrapper = cache.get(deptId);
    if (valueWrapper == null) {
      log.debug("Cache miss for departmentId: {}", deptId);
      return null;
    }
    log.debug("Cache hit for departmentId: {}", deptId);
    return new Entry((DepartmentResponse) valueWrapper.get());
  }

  // Read-through cache (SET NX) : if the value is not present, it will be computed and stored in the cache, never overwrites an entry that is already present.
  public void fillIfAbsent(Long deptId, @Nullable DepartmentResponse department) {
    try {
      cache.putIfAbsent(deptId, department);
    }catch (RuntimeException e){
      log.error("Error while putting value in cache for departmentId: {}", deptId, e);
    }
  }

  public void publishAfterCommit(Long deptId, DepartmentResponse department) {
    if(!TransactionSynchronizationManager.isSynchronizationActive()) {
      write(deptId, department);
      return;
    }
    TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {

      @Override
      public void afterCommit() {
        write(deptId, department);
      }
    });
  }

  /* For cases where the cache is updated within a transaction, and we want to evict the cache entry after the transaction commits.
     The caller must hold the row lock (SELECT ... FOR UPDATE) on the department row in the database before calling this method.
     This ensures that any subsequent reads will fetch the latest data from the database.
  */
  public void publishWhileLocked(Long deptId, DepartmentResponse department) {
    write(deptId, department);
    if(TransactionSynchronizationManager.isSynchronizationActive()) {
      TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
        @Override
        public void afterCompletion(int status) {
          if (status == TransactionSynchronization.STATUS_COMMITTED) {
            evict(deptId);
          }
        }
      });
    }
  }

  private void write(Long deptId, @Nullable DepartmentResponse department) {
    try {
      cache.put(deptId, department);
      log.debug("Cache updated for departmentId: {}", deptId);
    } catch (RuntimeException e) {
      log.error("Error while putting value in cache for departmentId: {}", deptId, e);
    }
  }

  private void evict(Long deptId) {
    try {
      cache.evict(deptId);
      log.debug("Cache evicted for departmentId: {}", deptId);
    } catch (RuntimeException e) {
      log.error("Error while evicting value in cache for departmentId: {}", deptId, e);
    }
  }

  private void evictAll() {
    try {
      cache.clear();
      log.debug("Cache cleared");
    } catch (RuntimeException e) {
      log.error("Error while clearing cache", e);
    }
  }

}
