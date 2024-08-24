package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetCinemaException extends ApplicationException {
    public GetCinemaException() {
        super(ErrorCodes.GET_CINEMA_NOT_FOUND.getMessage(), ErrorCodes.GET_CINEMA_NOT_FOUND.getCode());
    }
}
