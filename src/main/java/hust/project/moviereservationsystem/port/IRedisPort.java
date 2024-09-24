package hust.project.moviereservationsystem.port;

public interface IRedisPort {
    boolean tryLock(String key, String value, Long expiryTime);

    void releaseLock(String key);
}
