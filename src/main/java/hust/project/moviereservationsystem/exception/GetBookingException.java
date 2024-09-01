package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetBookingException extends ApplicationException {
    public GetBookingException() {
        super(ErrorCodes.GET_BOOKING_NOT_FOUND.getMessage(), ErrorCodes.GET_BOOKING_NOT_FOUND.getCode());
    }
}
