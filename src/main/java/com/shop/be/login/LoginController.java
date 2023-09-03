package com.shop.be.login;

import com.shop.be.config.AuthenticationRequest;
import com.shop.be.config.AuthenticationResponse;
import com.shop.be.config.AuthenticationService;
import com.shop.be.user.rq.AccountRq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AccountRq request) {
        return new ResponseEntity<>(service.register(request), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(service.authenticate(request), HttpStatus.OK);
    }

    public ResponseEntity<String> adminLogin(@RequestBody LoginRp rp) {
        return new ResponseEntity<>(service.login(rp), HttpStatus.OK);
    }

}
