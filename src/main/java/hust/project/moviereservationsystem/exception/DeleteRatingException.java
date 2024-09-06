package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteRatingException extends ApplicationException {
    public DeleteRatingException() {
        super(ErrorCodes.DELETE_RATING_FAIL.getMessage(), ErrorCodes.DELETE_RATING_FAIL.getCode());
    }
}
