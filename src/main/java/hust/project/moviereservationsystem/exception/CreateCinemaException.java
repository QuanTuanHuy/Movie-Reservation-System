package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateCinemaException extends ApplicationException {
    public CreateCinemaException() {
        super(ErrorCodes.CREATE_CINEMA_FAIL.getMessage(), ErrorCodes.CREATE_CINEMA_FAIL.getCode());
    }
}
