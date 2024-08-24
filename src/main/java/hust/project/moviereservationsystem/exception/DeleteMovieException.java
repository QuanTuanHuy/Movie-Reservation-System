package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteMovieException extends ApplicationException {
    public DeleteMovieException() {
        super(ErrorCodes.DELETE_MOVIE_FAIL.getMessage(), ErrorCodes.DELETE_MOVIE_FAIL.getCode());
    }
}
