package com.sodse.trade.redis.service;

import cn.hutool.crypto.SecureUtil;
import com.sodse.trade.domain.OrderSheet;
import com.sodse.trade.domain.Product;
import com.sodse.trade.redis.utils.SerializeUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

@Service
public class OrderRedisImpl implements OrderRedis{
    @Override
    public Boolean addOrderByRedis(OrderSheet orderSheet) {
        Long productId = orderSheet.getProductId();
        Jedis jedis = null;
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        jedis = pool.getResource();
        try {
            if (!jedis.exists("product_stock_"+productId)){
                byte[] bytes = jedis.get(("get_product_"+productId).getBytes());
                Product p =(Product) SerializeUtil.unserialize(bytes);
                jedis.set("product_stock_"+productId,p.getStock()+"");
            }else {
                if (jedis.get("product_stock_"+productId).equals("0")){
                    return false;
                }
                jedis.decrBy("product_stock_"+productId , 1);
                jedis.lpush(("order_product_"+productId).getBytes() ,SerializeUtil.serialize(orderSheet));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        pool.destroy();




        return true;
    }
}
