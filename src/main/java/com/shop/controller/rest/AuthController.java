package com.shop.controller.rest;

import com.shop.dto.UserDto;
import com.shop.service.UserDetailsServiceImpl;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestParam("j_username") String username,
                                   @RequestParam("j_password") String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        token.setDetails(userDetails);

        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new ResponseEntity<Object>(userService.getUser(auth.getName()), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto) {
        if (userService.getUser(userDto.getLogin()) == null) {
            userService.addUser(userDto);
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(userDto.getLogin(), userDto.getPassword());
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getLogin());
            token.setDetails(userDetails);
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new ResponseEntity<Object>(userService.getUser(auth.getName()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.GET)
    public boolean isLoginUnique(String login) {
        return null == userService.getUser(login);
    }
}
