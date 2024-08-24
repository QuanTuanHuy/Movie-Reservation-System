package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetCinemaHallException extends ApplicationException {
    public GetCinemaHallException() {
        super(ErrorCodes.GET_CINEMA_HALL_NOT_FOUND.getMessage(), ErrorCodes.GET_CINEMA_HALL_NOT_FOUND.getCode());
    }
}
