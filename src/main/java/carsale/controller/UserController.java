package carsale.controller;

import carsale.domain.User;
import carsale.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.TimeZone;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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
        var savedUser = userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "users/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }
}
