package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.port.IRedisPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisAdapter implements IRedisPort {
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean tryLock(String key, String value, Long expiryTime) {
        Boolean isLock = redisTemplate.opsForValue().setIfAbsent(key, value, expiryTime, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(isLock);
    }

    @Override
    public void releaseLock(String key) {
        redisTemplate.delete(key);
    }
}
