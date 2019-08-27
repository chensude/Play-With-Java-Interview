package com.yt;

/**
 * 获取锁的管理类
 */
public interface DistributeLocker {

    <T> T lock(String resourceName,AcquiredLockWorker<T> worker) throws UnableToAcquireLockException,Exception;

    <T> T lock(String resourceName,AcquiredLockWorker<T> worker,int lockTime) throws UnableToAcquireLockException,Exception;
}
