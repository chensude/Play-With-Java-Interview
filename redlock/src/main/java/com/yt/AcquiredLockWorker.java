package com.yt;

/**
 * 获取锁后需要处理的逻辑
 */
public interface AcquiredLockWorker<T> {

    T invokeAfterLockAcquire() throws Exception;
}
