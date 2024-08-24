package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateCityException extends ApplicationException {
    public CreateCityException() {
        super(ErrorCodes.CREATE_CITY_FAIL.getMessage(), ErrorCodes.CREATE_CITY_FAIL.getCode());
    }
}
