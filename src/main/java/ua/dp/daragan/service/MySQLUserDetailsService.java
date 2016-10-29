package ua.dp.daragan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.dp.daragan.GlobalConfig;
import ua.dp.daragan.entity.User;
import ua.dp.daragan.repository.UserRepository;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 *
 * @author bogdan
 */
@Service
public class MySQLUserDetailsService implements UserDetailsService, GlobalConfig {

    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails loadedUser;
        
        try {
            User client = users.findByUsername(username);
            loadedUser = new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), getGrantedAuthorities(username));
            
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
        Collection<? extends GrantedAuthority> authorities;
        if (username.equals("admin")) {
            authorities = asList(() -> "ROLE_ADMIN", () -> "ROLE_USER");
        } else {
            authorities = asList(() -> "ROLE_USER");
        }
        return authorities;
    }
}