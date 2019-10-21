package com.act.infinity.customer.factory;

import com.act.infinity.customer.constant.ResponseStatusCodeEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {
    public ResponseEntity<?> success(Object data, Class<?> clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatusCodeEnum.SUCCESS.getCode());
        responseStatus.setMessage(ResponseStatusCodeEnum.SUCCESS.getMessage());
        responseObject.setStatus(responseStatus);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.ok(responseObject);
    }
    
    public ResponseEntity<?> success() {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseStatusCodeEnum.SUCCESS.getCode());
        responseStatus.setMessage(ResponseStatusCodeEnum.SUCCESS.getMessage());
        responseObject.setStatus(responseStatus);
        return ResponseEntity.ok(responseObject);
    }
}
