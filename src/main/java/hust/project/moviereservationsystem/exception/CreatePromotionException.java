package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreatePromotionException extends ApplicationException {
    public CreatePromotionException() {
        super(ErrorCodes.CREATE_PROMOTION_FAIL.getMessage(), ErrorCodes.CREATE_PROMOTION_FAIL.getCode());
    }
}
