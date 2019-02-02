package ru.rosbank.morpher_test_task.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.rosbank.morpher_test_task.model.ApplicationUser;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = loadApplicationUserByUserName(username);
        return new User(applicationUser.getUsername(), applicationUser.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    public ApplicationUser loadApplicationUserByUserName(String userName) {
        return new ApplicationUser("batman", "{noop}pass");
    }
}

//{noop}