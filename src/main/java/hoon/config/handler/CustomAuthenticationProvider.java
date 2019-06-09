package hoon.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    // NOTE #9 AbstractUserDetailsAuthenticationProvider 의 authenticate() 를 대체

    private final UserServiceHandler userServiceHandler;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(UserServiceHandler userServiceHandler) {
        this.userServiceHandler = userServiceHandler;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        // NOTE #9 loadUserByUsername를 통해 userDetails를 받아오고(DB에서)
        UserDetails userDetails = userServiceHandler.loadUserByUsername(name);

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new UsernameNotFoundException("Not Found");
        }

        // NOTE #9 Authentication token 을 발행(중요!)
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
