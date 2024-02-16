package com.omkar.blogeditor.infra.model.response;

import com.omkar.blogeditor.infra.entity.Posts;
import com.omkar.blogeditor.infra.model.BaseResponse;
import com.omkar.blogeditor.infra.model.PostDTO;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GetPostResponse extends BaseResponse {

    public List<PostDTO> posts;

    @Builder
    public GetPostResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, List<PostDTO> posts) {
        super(httpStatus, status, responseCode, responseDescription);
        this.posts = posts;
    }
}
