package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteCinemaHallException extends ApplicationException {
    public DeleteCinemaHallException() {
        super(ErrorCodes.DELETE_CINEMA_HALL_FAIL.getMessage(), ErrorCodes.DELETE_CINEMA_HALL_FAIL.getCode());
    }
}
