package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetShowSeatException extends ApplicationException {
    public GetShowSeatException() {
        super(ErrorCodes.GET_SHOW_SEAT_NOT_FOUND.getMessage(), ErrorCodes.GET_SHOW_NOT_FOUND.getCode());
    }
}
