package com.yt;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class RedisLock implements DistributeLocker {

    private final static String LOCKER_PREFIX = "lock:";
    @Autowired
    private RedissonConnector redissonConnector;
    @Override
    public <T> T lock(String resourceName, AcquiredLockWorker<T> worker) throws UnableToAcquireLockException,Exception {
        return lock(resourceName,worker,100);
    }

    @Override
    public <T> T lock(String resourceName, AcquiredLockWorker<T> worker, int lockTime) throws UnableToAcquireLockException,Exception {
        RedissonClient client =
                redissonConnector.getClient();

        RLock lock = client.getLock(LOCKER_PREFIX + resourceName);

        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);

        if(success) {
            try{
                return worker.invokeAfterLockAcquire();
            }finally {
                lock.unlock();
            }
        }

        throw new UnableToAcquireLockException();

    }
}
