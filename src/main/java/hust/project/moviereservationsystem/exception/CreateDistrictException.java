package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateDistrictException extends ApplicationException {
    public CreateDistrictException() {
        super(ErrorCodes.CREATE_DISTRICT_FAIL.getMessage(), ErrorCodes.CREATE_DISTRICT_FAIL.getCode());
    }
}
