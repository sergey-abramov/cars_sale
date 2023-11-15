package carsale.handler;

import carsale.dto.AuthErrorDto;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(GlobalExceptionHandler.class.getSimpleName());

    private final ObjectMapper objectMapper;

    @ExceptionHandler(PersistentObjectException.class)
    public String handleAuth(BadCredentialsException e, Model model) {
        model.addAttribute("error", new AuthErrorDto(HttpStatus.UNAUTHORIZED.value(),
                "User with this name exists"));
        return "errors/errorPage";
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String handleAuthentication(BadCredentialsException e, Model model) {
        model.addAttribute("error", new AuthErrorDto(HttpStatus.UNAUTHORIZED.value(),
                "Incorrect login or password"));
        return "errors/errorPage";
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public void handleNullPointerException(Exception e, HttpServletRequest request,
                                           HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() { {
            put("message", "Some of fields empty");
            put("details", e.getMessage());
        }}));
        LOGGER.error(e.getMessage());
    }
}
