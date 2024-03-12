package com.omkar.blogeditor.buisness.service.impl;

import com.omkar.blogeditor.buisness.service.IndexService;
import com.omkar.blogeditor.infra.entity.User;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.UserDetailModel;
import com.omkar.blogeditor.infra.model.request.LoginRequest;
import com.omkar.blogeditor.infra.model.request.RegisterRequest;
import com.omkar.blogeditor.infra.model.response.LoginResponse;
import com.omkar.blogeditor.infra.repository.UserRepository;
import com.omkar.blogeditor.security.jwt.JwtUtil;
import com.omkar.blogeditor.util.response_builders.BaseFailure;
import com.omkar.blogeditor.util.response_builders.BaseSuccess;
import com.omkar.blogeditor.util.response_builders.failure.FailureResponseBuilder;
import com.omkar.blogeditor.util.response_builders.success.SuccessResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BaseSuccess baseSuccessBuilder;

    @Autowired
    private BaseFailure baseFailureBuilder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SuccessResponseBuilder successResponse;

    @Autowired
    private FailureResponseBuilder failureResponse;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public BaseResponse register(RegisterRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isEmpty()) {
            // build User
            User user = User.builder()
                    .name(request.getName())
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .active(true)
                    .role("user")
                    .build();
            //save user
            userRepository.save(user);

            return baseSuccessBuilder.baseSuccessResponse("User Created");
        } else {
            return baseFailureBuilder.baseFailResponse("User already Exists");
        }
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response;
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            User userFetched = user.get();
            if (passwordEncoder.matches(request.getPassword(),userFetched.getPassword())) {
                UserDetails  userDetails = userDetailsService.loadUserByUsername(request.getEmail());
                Map<String,Object> claims = generateClaims(userFetched);
                String jwt =jwtUtil.generateToken(userDetails,claims);
                response= successResponse.loginSuccess(jwt,user.get());
            }  else {
                response = failureResponse.loginFailed("Invalid Credentials");
            }
        } else {
            response = failureResponse.loginFailed("User Not Present");
        }
        return response;
    }

    public static Map<String, Object> generateClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email",user.getEmail());
        claims.put("username", user.getUsername());
        claims.put("role",user.getRole());
        return claims;
    }
}
