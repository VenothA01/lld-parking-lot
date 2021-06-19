package dailycodersecurity.dailycodersecurity.controller;

import dailycodersecurity.dailycodersecurity.config.utility.JwtUtility;
import dailycodersecurity.dailycodersecurity.model.JWTRequest;
import dailycodersecurity.dailycodersecurity.model.JWTResponse;
import dailycodersecurity.dailycodersecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String Home(){
        return "welcome to daily coder";
    }

    @PostMapping(value = "/token")
    public JWTResponse Authenticate(@RequestBody JWTRequest jwtRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(),jwtRequest.getPassword()
            ));
        }
        catch (BadCredentialsException badCredentialsException){
            throw new BadCredentialsException("INVALID CREDENTIALS ",badCredentialsException);
        }
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);


        System.out.println(new JWTResponse().getJWTToken());
        return new JWTResponse(token);

    }
}
