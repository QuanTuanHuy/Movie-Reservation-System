package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetGenreException extends ApplicationException {
    public GetGenreException() {
        super(ErrorCodes.GET_GENRE_NOT_FOUND.getMessage(), ErrorCodes.GET_GENRE_NOT_FOUND.getCode());
    }
}
