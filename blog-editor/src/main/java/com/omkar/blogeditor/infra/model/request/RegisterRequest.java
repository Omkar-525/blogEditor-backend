package com.omkar.blogeditor.infra.model.request;

import com.omkar.blogeditor.infra.model.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest extends BaseRequest {

    private String name;

    private String email;

    private String username;

    private String password;
}
