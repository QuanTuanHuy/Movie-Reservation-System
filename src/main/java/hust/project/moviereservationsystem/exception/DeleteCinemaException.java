package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteCinemaException extends ApplicationException {
    public DeleteCinemaException() {
        super(ErrorCodes.DELETE_CINEMA_FAIL.getMessage(), ErrorCodes.DELETE_CINEMA_FAIL.getCode());
    }
}
