package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateSeatTypeException extends ApplicationException {
    public CreateSeatTypeException() {
        super(ErrorCodes.CREATE_SEAT_TYPE_FAIL.getMessage(), ErrorCodes.CREATE_SEAT_TYPE_FAIL.getCode());
    }
}
