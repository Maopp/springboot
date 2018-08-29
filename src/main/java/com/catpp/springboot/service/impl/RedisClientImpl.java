package com.catpp.springboot.service.impl;

import com.catpp.springboot.service.CacheClient;
import com.catpp.springboot.utils.PropertiesReader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisClientImpl implements CacheClient {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public RedisClientImpl() {
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return this.redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void set(String key, Object val, long exp, TimeUnit unit) {
        if (StringUtils.isNotBlank(key)) {
            ValueOperations<String, Object> valueops = this.redisTemplate.opsForValue();
            valueops.set(this.getRedisKeyPrefix(key), val, exp, unit);
        }
    }

    @Override
    public Object get(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        } else {
            ValueOperations<String, Object> valueops = this.redisTemplate.opsForValue();
            Object value = valueops.get(this.getRedisKeyPrefix(key));
            return value;
        }
    }

    @Override
    public void delete(String key) {
        if (StringUtils.isNotBlank(key)) {
            this.redisTemplate.delete(this.getRedisKeyPrefix(key));
        }
    }

    @Override
    public Boolean exists(String key) {
        return StringUtils.isNotBlank(key) ? this.redisTemplate.hasKey(this.getRedisKeyPrefix(key)) : false;
    }

    @Override
    public boolean setIfAbsent(String key, Object val, long exp) {
        ValueOperations<String, Object> valueops = this.redisTemplate.opsForValue();
        key = this.getRedisKeyPrefix(key);
        boolean result = valueops.setIfAbsent(key, val);
        if (result) {
            this.set(key, val, exp, TimeUnit.SECONDS);
        }
        return result;
    }

    @Override
    public void set(String key, Object val, long exp) {
        ValueOperations<String, Object> valueops = this.redisTemplate.opsForValue();
        valueops.set(key, val, exp, TimeUnit.SECONDS);
    }

    @Override
    public void set(String key, Object val) {
        ValueOperations<String, Object> valueops = this.redisTemplate.opsForValue();
        valueops.set(this.getRedisKeyPrefix(key), val);
    }

    @Override
    public Long incr(String key, Long offset) {
        final RedisSerializer<String> serializer = this.redisTemplate.getStringSerializer();
        long val = (Long) this.redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keyArr = serializer.serialize(RedisClientImpl.this.getRedisKeyPrefix(key));
                Object value = redisConnection.incr(keyArr);
                return Long.parseLong(value.toString());
            }
        });
        return val;
    }

    @Override
    public Integer getAndSet(String ket, int val) {
        final RedisSerializer<String> serializer = this.redisTemplate.getStringSerializer();
        this.redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keyArr = serializer.serialize(RedisClientImpl.this.getRedisKeyPrefix(ket));
                byte[] valArr = serializer.serialize(val + "");
                byte[] retvalue = connection.getSet(keyArr, valArr);
                String str = (String) serializer.deserialize(retvalue);
                return  str;
            }
        });
        return 1;
    }

    @Override
    public void evict(String key) {
        this.delete(this.getRedisKeyPrefix(key));
    }

    @Override
    public boolean setExpireTime(String key, long exp) {
        RedisSerializer<String> serializer = this.redisTemplate.getStringSerializer();
        String redisKey = this.getRedisKeyPrefix(key);
        RedisConnection connection = this.redisTemplate.getConnectionFactory().getConnection();
        boolean isSuccess = connection.expireAt(serializer.serialize(redisKey), exp);
        return isSuccess;
    }

    @Override
    public Long ttl(String key) {
        if (StringUtils.isNotBlank(key)) {
            return redisTemplate.getExpire(key);
        } else {
            return null;
        }
    }

    @Override
    public Set<String> keys(String pattern) {
        if (StringUtils.isNotBlank(pattern)) {
            return redisTemplate.keys(pattern);
        }
        return null;
    }

    @Override
    public void hSet(String key, String field, Object val) {
        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(field)) {
            HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
            opsForHash.put(key, field, val);
        }
    }

    @Override
    public Object hGet(String key, String field) {

        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(field)) {
            HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
            Object obj = opsForHash.get(key, field);
            return obj;
        } else {
            return null;
        }
    }

    @Override
    public void hDel(String key, Object... fields) {
        if (StringUtils.isNotBlank(key)) {
            HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
            opsForHash.delete(key, fields);
        }
    }

    @Override
    public Map<Object, Object> hGetAll(String key) {
        if (StringUtils.isNotBlank(key)) {
            HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
            opsForHash.entries(key);
        }
        return null;
    }

    @Override
    public Long lPush(String key, Object val) {
        if (StringUtils.isNotBlank(key)) {
            ListOperations<String, Object> opsForList = redisTemplate.opsForList();
            Long leftPush = opsForList.leftPush(key, val);
            return leftPush;
        }
        return null;
    }

    @Override
    public Object lPop(String key) {
        if (StringUtils.isNotBlank(key)) {
            ListOperations<String, Object> opsForList = redisTemplate.opsForList();
            Object leftPop = opsForList.leftPop(key);
        }
        return null;
    }

    @Override
    public Long rPush(String key, Object val) {
        if (StringUtils.isNotBlank(key)) {
            ListOperations<String, Object> opsForList = redisTemplate.opsForList();
            return opsForList.rightPush(key, val);
        }
        return null;
    }

    private String getRedisKeyPrefix(String key) {
        String prefixKey = PropertiesReader.getValue("resource", "redis.key.prefix");
        return prefixKey + key;
    }
}
