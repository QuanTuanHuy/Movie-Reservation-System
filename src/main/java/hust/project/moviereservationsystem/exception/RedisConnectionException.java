package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class RedisConnectionException extends ApplicationException {
    public RedisConnectionException() {
        super(ErrorCodes.REDIS_CONNECTION_ERROR.getMessage(), ErrorCodes.REDIS_CONNECTION_ERROR.getCode());
    }
}
