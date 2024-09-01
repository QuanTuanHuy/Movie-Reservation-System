package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateBookingException extends ApplicationException {
    public CreateBookingException() {
        super(ErrorCodes.CREATE_BOOKING_FAIL.getMessage(), ErrorCodes.CREATE_BOOKING_FAIL.getCode());
    }
}
