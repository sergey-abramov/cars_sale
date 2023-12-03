package carsale.service;

import carsale.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;

    public User registration(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.save(user);
    }

    public UserDetails authentication(User user) {
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        return userService.loadUserByUsername(user.getUsername());
    }
}
