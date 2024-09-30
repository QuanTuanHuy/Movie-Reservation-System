package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UpdateMovieElasticException extends ApplicationException {
    public UpdateMovieElasticException() {
        super(ErrorCodes.UPDATE_MOVIE_ELASTICSEARCH_FAIL.getMessage(), ErrorCodes.UPDATE_MOVIE_ELASTICSEARCH_FAIL.getCode());
    }
}
