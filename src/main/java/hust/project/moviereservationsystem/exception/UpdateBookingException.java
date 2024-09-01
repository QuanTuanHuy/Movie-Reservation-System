package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UpdateBookingException extends ApplicationException {
    public UpdateBookingException() {
        super(ErrorCodes.UPDATE_BOOKING_FAIL.getMessage(), ErrorCodes.UPDATE_BOOKING_FAIL.getCode());
    }
}
