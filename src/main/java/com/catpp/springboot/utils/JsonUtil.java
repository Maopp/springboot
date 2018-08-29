package com.catpp.springboot.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import javax.management.ObjectName;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.catpp.springboot.utils
 *
 * @Author cat_pp
 * @Date 2018/8/27
 * @Description json工具类
 */
@Slf4j
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 将对象序列化为json字符串
     * @param object 要转换的对象
     * @return 对象序列计划后的json字符串
     */
    public static String toJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            LogUtil.error(log, "生成兑现那个json字符串失败，对象：{}", object);
            throw new RuntimeException(e);
        }
    }

    /**
     * json反序列化为map
     * @param jsonString json字符串
     * @return 反序列化后的map
     */
    public static Map<String, Object> toMap(String jsonString) {
        return fromJson(jsonString, Map.class);
    }

    /**
     * json转换为对象
     * @param jsonString json字符串
     * @param clazz 对象类型
     * @param <T> 对象泛型
     * @return 转换后的对象
     */
    private static <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(jsonString, clazz);
        } catch (IOException e) {
            LogUtil.error(log, "转换json字符串为对象失败，json为：{}，类名为：{}", jsonString, clazz.getName());
            throw new RuntimeException(e);
        }
    }

    /**
     * json转list
     * @param json json字符串
     * @param clazz 类信息
     * @param <E> 泛型
     * @return list集合
     */
    public static <E> List<E> toList(String json, Class<E> clazz) {
        List<E> list;

        try {
            list = OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
        } catch (Exception e) {
            LogUtil.error(log,"转换json字符串为list集合失败，json为：{}，类名为：{}", json, clazz.getName());
            throw new RuntimeException(e);
        }

        return list;
    }

    /**
     * json转换json节点
     * @param json 要转换的json字符串
     * @return json节点
     */
    public static JsonNode toNode(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, JsonNode.class);
        } catch (Exception e) {
            LogUtil.error(log, "转换json字符串为json节点失败，json为：{}", json);
            throw new RuntimeException(e);
        }
    }
}
