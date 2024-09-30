package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class DeleteMovieElasticException extends ApplicationException {
    public DeleteMovieElasticException() {
        super(ErrorCodes.DELETE_MOVIE_ELASTICSEARCH_FAIL.getMessage(), ErrorCodes.DELETE_MOVIE_ELASTICSEARCH_FAIL.getCode());
    }
}
