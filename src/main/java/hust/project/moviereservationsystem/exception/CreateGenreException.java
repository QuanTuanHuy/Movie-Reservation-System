package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateGenreException extends ApplicationException {
    public CreateGenreException() {
        super(ErrorCodes.CREATE_GENRE_FAIL.getMessage(), ErrorCodes.CREATE_GENRE_FAIL.getCode());
    }
}
