package com.bank.customerprofile.controllers;

import com.bank.customerprofile.Utility.JwtUtil;
import com.bank.customerprofile.models.DTOs.JwtResponse;
import com.bank.customerprofile.models.DTOs.LoginRequest;
import com.bank.customerprofile.models.DTOs.RefreshTokenRequest;
import com.bank.customerprofile.models.entities.RefreshToken;
import com.bank.customerprofile.models.entities.User;
import com.bank.customerprofile.repository.RefreshTokenRepository;
import com.bank.customerprofile.repository.UserRepository;
import com.bank.customerprofile.services.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailService;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails =
                userDetailService.loadUserByUsername(request.getUsername());

        String token = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByUsername(request.getUsername());
                RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);

        String refreshtokenStep1 = refreshToken.getToken();

        String newAccessToken = jwtUtil.generateToken(userDetails);


        return ResponseEntity.ok(
                Map.of(
                        "accessToken", newAccessToken
                )
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresToken(@RequestBody RefreshTokenRequest request){
        RefreshToken refreshToken = refreshTokenRepository
                .findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .orElseThrow(() -> new RuntimeException("Invalid Refresh Token"));

        User user = refreshToken.getUser();

        UserDetails userDetails = userDetailService.loadUserByUsername(user.getUsername());

        String newAccesToken = jwtUtil.generateToken(userDetails);

        RefreshToken newRefreshToken = refreshTokenService.createRefreshToken(user);

        return ResponseEntity.ok(
                Map.of(
                        "accessToken",newAccesToken,
                        "refreshToken", newRefreshToken.getToken()
                )
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String username){

        User user = userRepository.findByUsername(username);


        refreshTokenService.deleteByUser(user);

        return ResponseEntity.ok("Logged out successfully");
    }


}
