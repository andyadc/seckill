package com.andyadc.seckill.infrastructure.lock.factory;

import com.andyadc.seckill.infrastructure.lock.DistributedLock;

public interface DistributedLockFactory {

    DistributedLock get(String key);
}
