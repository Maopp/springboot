package com.catpp.springboot.service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface CacheClient {

    void set(String key, Object val, long exp, TimeUnit unit);

    Object get(String key);

    void delete(String key);

    Boolean exists(String key);

    boolean setIfAbsent(String key, Object val, long exp);

    void set(String key, Object val, long exp);

    void set(String key, Object val);

    Long incr(String key, Long offset);

    Integer getAndSet(String ket, int val);

    void evict(String key);

    boolean setExpireTime(String key, long exp);

    /**
     * 实现命令：TTL key，以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)。
     *
     * @param key
     * @return
     */
    Long ttl(String key);

    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     *
     * @param pattern
     * @return
     */
    Set<String> keys(String pattern);

    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     *
     * @param key
     * @param field
     * @param val
     */
    void hSet(String key, String field, Object val);

    /**
     * 实现命令：HGET key field，返回哈希表 key中给定域 field的值
     *
     * @param key
     * @param field
     * @return
     */
    Object hGet(String key, String field);

    /**
     * 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     *
     * @param key
     * @param fields
     */
    void hDel(String key, Object... fields);

    /**
     * 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
     *
     * @param key
     * @return
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * 实现命令：LPUSH key value，将一个值 value插入到列表 key的表头
     *
     * @param key
     * @param val
     * @return 执行 LPUSH命令后，列表的长度。
     */
    Long lPush(String key, Object val);

    /**
     * 实现命令：LPOP key，移除并返回列表 key的头元素。
     *
     * @param key
     * @return 列表key的头元素。
     */
    Object lPop(String key);

    /**
     * 实现命令：RPUSH key value，将一个值 value插入到列表 key的表尾(最右边)。
     *
     * @param key
     * @param val
     * @return 执行 LPUSH命令后，列表的长度。
     */
    Long rPush(String key, Object val);
}
