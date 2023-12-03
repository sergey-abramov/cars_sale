package carsale.service;

import carsale.domain.User;
import carsale.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            User user = findByLogin(login);
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    emptyList());
        } catch (Exception e) {
            throw new UsernameNotFoundException(login);
        }
    }
}
