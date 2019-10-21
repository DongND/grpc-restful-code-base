package com.act.infinity.customer.factory;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":\"").append(code).append("\"");
        sb.append(", \"message\":\"").append(message).append("\"");
        sb.append('}');
        return sb.toString();
    }
}
