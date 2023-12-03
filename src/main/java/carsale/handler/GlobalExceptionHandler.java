package carsale.handler;

import carsale.dto.ErrorDto;
import org.hibernate.PersistentObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.sasl.AuthenticationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(GlobalExceptionHandler.class.getSimpleName());

    @ExceptionHandler(PersistentObjectException.class)
    public String handleSave(PersistentObjectException e, Model model) {
        model.addAttribute("error", new ErrorDto(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
        LOGGER.error(e.getMessage());
        return "errors/errorPage";
    }

    @ExceptionHandler(AuthenticationException.class)
    public String handleDisAuth(AuthenticationException e, Model model) {
        model.addAttribute("error", new ErrorDto(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
        LOGGER.error(e.getMessage());
        return "errors/errorPage";
    }

    @ExceptionHandler(LockedException.class)
    public String handleLockAuth(LockedException e, Model model) {
        model.addAttribute("error", new ErrorDto(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
        LOGGER.error(e.getMessage());
        return "errors/errorPage";
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String handleAuthentication(BadCredentialsException e, Model model) {
        model.addAttribute("error", new ErrorDto(HttpStatus.UNAUTHORIZED.value(),
                "Incorrect login or password"));
        LOGGER.error(e.getMessage());
        return "errors/errorPage";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(Exception e, Model model) {
        model.addAttribute("error", new ErrorDto(HttpStatus.NOT_FOUND.value(), e.getMessage()));
        LOGGER.error(e.getMessage());
        return "errors/errorPage";
    }
}
