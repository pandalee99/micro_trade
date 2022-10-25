package com.sodse.trade.redis.service;

import com.sodse.trade.domain.OrderSheet;

public interface OrderRedis {
    Boolean addOrderByRedis(OrderSheet orderSheet);
}
