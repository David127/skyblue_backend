package com.backend.skyblue.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysHttpResponse {
    Integer status;
    String message;
    Object data;

    public static SysHttpResponse ok (Object data) {
        return new SysHttpResponse(HttpStatus.OK.value(), "success", data);
    }
 
    public static SysHttpResponse ok (String message, Object data) {
        return new SysHttpResponse(HttpStatus.OK.value(), message, data);
    }

    public static SysHttpResponse error4xx (String message, Object data) {
        return new SysHttpResponse(HttpStatus.UNAUTHORIZED.value(), message, data);
    }

    public static SysHttpResponse error5xx (String message, Object data) {
        return new SysHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, data);
    }
    
}
