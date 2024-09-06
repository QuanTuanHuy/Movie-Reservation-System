package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetRatingException extends ApplicationException {
    public GetRatingException() {
        super(ErrorCodes.GET_RATING_NOT_FOUND.getMessage(), ErrorCodes.GET_RATING_NOT_FOUND.getCode());
    }
}
