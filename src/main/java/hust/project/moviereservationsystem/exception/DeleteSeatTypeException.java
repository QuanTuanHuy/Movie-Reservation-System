package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteSeatTypeException extends ApplicationException {
    public DeleteSeatTypeException() {
        super(ErrorCodes.DELETE_SHOW_FAIL.getMessage(), ErrorCodes.DELETE_SHOW_FAIL.getCode());
    }
}
