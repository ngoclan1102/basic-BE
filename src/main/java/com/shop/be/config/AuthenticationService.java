package com.shop.be.config;

import com.shop.be.Constant.Constant;
import com.shop.be.entity.Account;
import com.shop.be.entity.HistoryLogin;
import com.shop.be.login.LoginRp;
import com.shop.be.user.repository.AccountRepo;
import com.shop.be.user.repository.HistoryLoginRepo;
import com.shop.be.user.rq.AccountRq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private AccountRepo accountRepo;

    private PasswordEncoder passwordEncoder;

    private JWTService jwtService;

    private AuthenticationManager authenticationManager;

    private HistoryLoginRepo loginRepo;

    public AuthenticationResponse register(AccountRq rq) {
        Account a = Account.builder()
                .userName(rq.getUserName())
                .pass(passwordEncoder.encode(rq.getPassword()))
                .role(Constant.Role.USER)
                .build();
        accountRepo.save(a);

        String jwtToken = jwtService.generateToken(a);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest rq) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(rq.getUsername(), rq.getPassword()));
        Account account = accountRepo.findAccountByUserName(rq.getUsername());

        String jwtToken = jwtService.generateToken(account);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public String login(LoginRp rp) {
        HistoryLogin historyLogin = new HistoryLogin();
        historyLogin.setIdUser(rp.getIdUser());
        historyLogin.setUsername(rp.getUsername());
        historyLogin.setStartLogin(LocalDateTime.now());
        loginRepo.save(historyLogin);
        return Constant.Success;
    }

}
