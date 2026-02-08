package com.example.mongo_spring.gson;

import com.google.gson.Gson;
import org.jspecify.annotations.NonNull;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import java.nio.charset.StandardCharsets;

public class GsonRedisSerializer<T> implements RedisSerializer<T> {
    private final Gson gson;
    private final Class<T> clazz;

    public GsonRedisSerializer(Class<T> clazz) {
        this.gson = new Gson();
        this.clazz = clazz;
    }

    @Override
    public byte @NonNull [] serialize(T t) throws SerializationException {
        if (t == null) return new byte[0];
        return gson.toJson(t).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) return null;
        return gson.fromJson(new String(bytes, StandardCharsets.UTF_8), clazz);
    }
}