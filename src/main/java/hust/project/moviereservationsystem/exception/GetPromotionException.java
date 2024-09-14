package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetPromotionException extends ApplicationException {
    public GetPromotionException() {
        super(ErrorCodes.GET_PROMOTION_NOT_FOUND.getMessage(), ErrorCodes.GET_PROMOTION_NOT_FOUND.getCode());
    }
}
