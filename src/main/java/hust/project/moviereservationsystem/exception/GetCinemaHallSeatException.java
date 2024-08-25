package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetCinemaHallSeatException extends ApplicationException {
    public GetCinemaHallSeatException() {
        super(ErrorCodes.GET_CINEMA_HALL_SEAT_NOT_FOUND.getMessage(),
                ErrorCodes.GET_CINEMA_HALL_SEAT_NOT_FOUND.getCode());
    }
}
