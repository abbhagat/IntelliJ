package lld.threadpool;

public interface IThreadPool {
  void submitTask(Runnable task);
  void awaitCompletion();
  void stop();
}
