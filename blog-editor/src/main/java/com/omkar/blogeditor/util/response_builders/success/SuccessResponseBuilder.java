package com.omkar.blogeditor.util.response_builders.success;

import com.omkar.blogeditor.util.response_builders.BaseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuccessResponseBuilder {

    @Autowired
    private BaseSuccess baseSuccess;

}
