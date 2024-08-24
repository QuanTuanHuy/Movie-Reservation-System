package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateMovieGenreException extends ApplicationException {
    public CreateMovieGenreException() {
        super(ErrorCodes.CREATE_MOVIE_GENRE_FAIL.getMessage(), ErrorCodes.CREATE_MOVIE_GENRE_FAIL.getCode());
    }
}
