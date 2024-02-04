package com.omkar.blogeditor.buisness.service.impl;

import com.omkar.blogeditor.buisness.service.IndexService;
import com.omkar.blogeditor.infra.entity.User;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.UserDetailModel;
import com.omkar.blogeditor.infra.model.request.RegisterRequest;
import com.omkar.blogeditor.infra.repository.UserRepository;
import com.omkar.blogeditor.util.response_builders.BaseFailure;
import com.omkar.blogeditor.util.response_builders.BaseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BaseSuccess baseSuccess;

    @Autowired
    private BaseFailure baseFailure;

    @Autowired
    private UserDetailModel userDetailModel;


    @Override
    public BaseResponse register(RegisterRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (!userOptional.isPresent()) {
            // build User
            User user = User.builder()
                    .name(request.getName())
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .active(true)
                    .role("user")
                    .build();
            //save user
            userRepository.save(user);

            return baseSuccess.baseSuccessResponse("User Created");
        } else {
            return baseFailure.baseFailResponse("User already Exists");
        }
    }
}
