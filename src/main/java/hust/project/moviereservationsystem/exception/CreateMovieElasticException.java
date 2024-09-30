package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateMovieElasticException extends ApplicationException {
    public CreateMovieElasticException() {
        super(ErrorCodes.CREATE_MOVIE_ELASTICSEARCH_FAIL.getMessage(), ErrorCodes.CREATE_MOVIE_ELASTICSEARCH_FAIL.getCode());
    }
}
