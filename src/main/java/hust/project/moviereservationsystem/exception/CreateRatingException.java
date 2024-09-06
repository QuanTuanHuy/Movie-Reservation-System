package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateRatingException extends ApplicationException {
    public CreateRatingException() {
        super(ErrorCodes.CREATE_RATING_FAIL.getMessage(), ErrorCodes.CREATE_RATING_FAIL.getCode());
    }
}
