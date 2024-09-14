package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UpdatePromotionException extends ApplicationException {
    public UpdatePromotionException() {
        super(ErrorCodes.UPDATE_PROMOTION_FAIL.getMessage(), ErrorCodes.UPDATE_PROMOTION_FAIL.getCode());
    }
}
