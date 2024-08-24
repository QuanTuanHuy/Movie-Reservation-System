package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateCinemaHallException extends ApplicationException {
    public CreateCinemaHallException() {
        super(ErrorCodes.CREATE_CINEMA_HALL_FAIL.getMessage(), ErrorCodes.CREATE_CINEMA_HALL_FAIL.getCode());
    }
}
