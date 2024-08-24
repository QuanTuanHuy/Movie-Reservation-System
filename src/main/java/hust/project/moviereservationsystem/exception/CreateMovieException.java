package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateMovieException extends ApplicationException {
    public CreateMovieException() {
        super(ErrorCodes.CREATE_MOVIE_FAIL.getMessage(), ErrorCodes.CREATE_MOVIE_FAIL.getCode());
    }
}
