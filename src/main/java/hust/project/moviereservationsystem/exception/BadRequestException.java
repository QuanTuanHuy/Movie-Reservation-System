package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class BadRequestException extends ApplicationException {
    public BadRequestException() {
        super(ErrorCodes.BAD_REQUEST.getMessage(), ErrorCodes.BAD_REQUEST.getCode());
    }
}
