package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.request.SendEmailRequest;
import hust.project.moviereservationsystem.entity.response.SendEmailResponse;

public interface IEmailService {
    SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest);
}
