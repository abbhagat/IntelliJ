package lld.threadpool;

public interface IThreadPool {
  void submitTask(Runnable task);
  void awaitTaskCompletion();
  void stop();
}
