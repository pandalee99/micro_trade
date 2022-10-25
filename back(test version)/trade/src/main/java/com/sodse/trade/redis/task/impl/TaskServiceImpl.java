package com.sodse.trade.redis.task.impl;



import com.alibaba.fastjson.JSON;
import com.sodse.trade.domain.OrderSheet;
import com.sodse.trade.redis.task.TaskService;
import com.sodse.trade.redis.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {


    @Override
    // 每天半夜1点钟开始执行任务
//    @Scheduled(cron = "0 0 1 * * ?")
    // 下面是用于测试的配置，每分钟执行一次任务
     @Scheduled(fixedRate = 1000 * 5)
    public void purchaseTask() {
        Jedis jedis = null;
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        jedis = pool.getResource();
        try {

        System.out.println("定时任务开始......");
        List<byte[]> bytes=jedis.lrange("order_product_885036".getBytes(), 0, -1);
        for (byte[] b:bytes) {
            OrderSheet orderSheet =(OrderSheet) SerializeUtil.unserialize(b);
            System.out.println(JSON.toJSONString(orderSheet));
        }
        System.out.println("定时任务结束......");

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
/// ... 当关闭应用程序时:
        pool.destroy();
    }
    

}