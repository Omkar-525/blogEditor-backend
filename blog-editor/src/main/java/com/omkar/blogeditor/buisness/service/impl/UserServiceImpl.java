package com.omkar.blogeditor.buisness.service.impl;

import com.omkar.blogeditor.buisness.service.UserService;
import com.omkar.blogeditor.infra.entity.User;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.UserDetailModel;
import com.omkar.blogeditor.infra.model.request.ChangePasswordRequest;
import com.omkar.blogeditor.infra.model.response.ProfileResponse;
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

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private FailureResponseBuilder failureResponse;

    @Autowired
    private SuccessResponseBuilder successResponse;

    @Autowired
    private BaseSuccess baseSuccess;

    @Autowired
    private BaseFailure baseFailure;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ProfileResponse getProfile(String authorizationHeader) {
        String jwt = authorizationHeader.substring(7);
        String email = jwtUtil.extractUsername(jwt);
        UserDetailModel userDetails = (UserDetailModel) userDetailsService.loadUserByUsername(email);

        if (Boolean.TRUE.equals(jwtUtil.validateToken(jwt, userDetails))) {
            try {
                Optional<User> user = userRepository.findByEmail(email);
                if (user.isPresent()) {
                    return successResponse.getUser( user.get());

                } else {
                    return failureResponse.getUser("user not present");
                }
            } catch (Exception ex) {
                return failureResponse.getUser("Something went wrong");
            }
        }
        return failureResponse.getUser("Invalid JWT");
    }

    @Override
    public BaseResponse changePassword(String authorizationHeader, ChangePasswordRequest request) {
        String jwt = authorizationHeader.substring(7);
        String email = jwtUtil.extractUsername(jwt);
        UserDetailModel userDetails = (UserDetailModel) userDetailsService.loadUserByUsername(email);
        if (Boolean.TRUE.equals(jwtUtil.validateToken(jwt, userDetails))) {
            try {
                Optional<User> user = userRepository.findByEmail(email);
                if (user.isPresent()) {
                    if(passwordEncoder.matches(request.getOldPassword(),user.get().getPassword())){
                        User u = user.get();
                        u.setPassword(passwordEncoder.encode(request.newPassword));
                        userRepository.save(u);
                        return baseSuccess.baseSuccessResponse("Password changed");
                    }else{
                        return baseFailure.baseFailResponse("Invalid password");
                    }
                }
                return baseFailure.baseFailResponse("Invalid user");
            } catch (Exception ex) {
                ex.printStackTrace();
                return baseFailure.baseFailResponse("something went wrong");
            }
        }
        return baseFailure.baseFailResponse("Invalid JWt");
    }

}
