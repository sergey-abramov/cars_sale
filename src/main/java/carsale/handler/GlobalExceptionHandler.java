package carsale.handler;

import carsale.dto.ErrorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.hibernate.PersistentObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(GlobalExceptionHandler.class.getSimpleName());

    private final ObjectMapper objectMapper;

    @ExceptionHandler(PersistentObjectException.class)
    public String handleAuth(PersistentObjectException e, Model model) {
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
    public void handleNullPointerException(Exception e, Model model) throws IOException {
        model.addAttribute("error", new ErrorDto(HttpStatus.NOT_FOUND.value(), e.getMessage()));
        LOGGER.error(e.getMessage());
    }
}
