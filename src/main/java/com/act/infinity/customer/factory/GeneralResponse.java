package com.act.infinity.customer.factory;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneralResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private T data;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("status=").append(status);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
