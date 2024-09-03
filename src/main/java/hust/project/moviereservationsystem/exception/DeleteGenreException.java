package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteGenreException extends ApplicationException {
    public DeleteGenreException() {
        super(ErrorCodes.DELETE_GENRE_FAIL.getMessage(), ErrorCodes.DELETE_GENRE_FAIL.getCode());
    }
}
