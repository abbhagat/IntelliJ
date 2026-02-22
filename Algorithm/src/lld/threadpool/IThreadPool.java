package lld.threadpool;

public interface IThreadPool {
  void addTaskToQueue(Runnable task);
  void waitUntilAllTasksFinished();
  void stop();
}
