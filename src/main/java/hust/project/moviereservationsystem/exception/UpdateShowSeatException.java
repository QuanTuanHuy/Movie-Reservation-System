package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UpdateShowSeatException extends ApplicationException {
    public UpdateShowSeatException() {
        super(ErrorCodes.UPDATE_SHOW_SEAT_FAIL.getMessage(), ErrorCodes.UPDATE_SHOW_SEAT_FAIL.getCode());
    }
}
