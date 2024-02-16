package com.omkar.blogeditor.infra.model.request;

import com.omkar.blogeditor.infra.model.BaseRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest extends BaseRequest {

    private String email;

    private String password;
}
