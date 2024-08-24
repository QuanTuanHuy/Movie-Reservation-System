package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetCityException extends ApplicationException {
    public GetCityException() {
        super(ErrorCodes.GET_CITY_NOT_FOUND.getMessage(), ErrorCodes.GET_CITY_NOT_FOUND.getCode());
    }
}
