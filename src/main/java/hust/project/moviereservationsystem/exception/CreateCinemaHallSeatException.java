package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateCinemaHallSeatException extends ApplicationException {
    public CreateCinemaHallSeatException() {
        super(ErrorCodes.CREATE_CINEMA_HALL_SEAT_FAIL.getMessage(),
                ErrorCodes.CREATE_CINEMA_HALL_SEAT_FAIL.getCode());
    }
}
