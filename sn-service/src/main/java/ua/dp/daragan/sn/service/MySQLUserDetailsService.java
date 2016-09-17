package ua.dp.daragan.sn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.dp.daragan.sn.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */

public class MySQLUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails loadedUser;

        try {
            ua.dp.daragan.sn.domain.User client = users.findByUsername(username);
            loadedUser = new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), DummyAuthority.getAuth());

        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }

    static class DummyAuthority implements GrantedAuthority {

        static Collection<GrantedAuthority> getAuth() {

            List<GrantedAuthority> res = new ArrayList<>(1);
            res.add(new DummyAuthority());
            return res;
        }

        @Override
        public String getAuthority() {
            return "ROLE_USER";
        }
    }
}