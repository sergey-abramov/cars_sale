package carsale.controller;

import carsale.domain.User;
import carsale.service.AuthService;
import carsale.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.TimeZone;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final AuthService service;

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        var zones = new ArrayList<TimeZone>();
        for (String timeId : ZoneId.getAvailableZoneIds()) {
            zones.add(TimeZone.getTimeZone(timeId));
        }
        model.addAttribute("zones", zones);
        return "users/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute User user) {
        var savedUser = service.registration(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "users/login";
    }

    @PostMapping("/login_page")
    public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
        var user1 = service.authentication(user);
        request.getSession()
                .setAttribute("remoteUser", user1);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }
}
