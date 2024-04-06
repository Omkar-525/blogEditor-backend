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
public class SetPostRequest extends BaseRequest {

    public String title;

    public String content;

    public String category;

}
