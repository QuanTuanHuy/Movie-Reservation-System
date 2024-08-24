package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetDistrictException extends ApplicationException {
    public GetDistrictException() {
        super(ErrorCodes.GET_DISTRICT_NOT_FOUND.getMessage(), ErrorCodes.GET_DISTRICT_NOT_FOUND.getCode());
    }
}
