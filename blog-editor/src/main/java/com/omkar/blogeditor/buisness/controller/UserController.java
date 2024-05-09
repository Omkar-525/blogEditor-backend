package com.omkar.blogeditor.buisness.controller;

import com.omkar.blogeditor.buisness.service.UserService;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.request.ChangePasswordRequest;
import com.omkar.blogeditor.infra.model.response.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ProfileResponse getUserProfile(@RequestHeader(value = "Authorization") String authorizationHeader){
        return userService.getProfile(authorizationHeader);
    }
    @PostMapping("/changepassword")
    public BaseResponse changePassword(@RequestHeader(value = "Authorization") String authorizationHeader,
                                       @RequestBody ChangePasswordRequest request){
        return userService.changePassword(authorizationHeader,request);
    }
}
