/*
package ua.dp.daragan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.dp.daragan.repository.UserRepository;

import java.util.Collection;

import static java.util.Arrays.asList;

*/
/**
 *
 * @author bogdan
 *//*

@Service
public class DBUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ua.dp.daragan.entity.User person = users.findByUsername(username);

        if (person == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return new User(username, person.getPassword(), getGrantedAuthorities(username));
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
}*/
