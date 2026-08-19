package lld.jobscheduler;

public record Job(String id, Runnable task, long executeAt) {}
