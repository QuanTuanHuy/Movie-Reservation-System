package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteShowException extends ApplicationException {
    public DeleteShowException() {
        super(ErrorCodes.DELETE_SHOW_FAIL.getMessage(), ErrorCodes.DELETE_CINEMA_FAIL.getCode());
    }
}
