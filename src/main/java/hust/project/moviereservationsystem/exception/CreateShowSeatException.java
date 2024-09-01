package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateShowSeatException extends ApplicationException {
    public CreateShowSeatException() {
        super(ErrorCodes.CREATE_SHOW_SEAT_FAIL.getMessage(), ErrorCodes.CREATE_SHOW_SEAT_FAIL.getCode());
    }
}
