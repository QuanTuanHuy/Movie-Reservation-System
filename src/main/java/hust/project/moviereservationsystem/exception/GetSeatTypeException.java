package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetSeatTypeException extends ApplicationException {
    public GetSeatTypeException() {
        super(ErrorCodes.GET_SEAT_TYPE_NOT_FOUND.getMessage(), ErrorCodes.GET_SEAT_TYPE_NOT_FOUND.getCode());
    }
}
