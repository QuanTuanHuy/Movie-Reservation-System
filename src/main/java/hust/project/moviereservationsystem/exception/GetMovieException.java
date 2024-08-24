package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetMovieException extends ApplicationException {
    public GetMovieException() {
        super(ErrorCodes.GET_MOVIE_NOT_FOUND.getMessage(), ErrorCodes.GET_ROLE_NOT_FOUND.getCode());
    }
}
