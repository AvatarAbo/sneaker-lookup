package com.example.sneakerlookup.dto;

public class RequestDto<T> {
    private T data = null;

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

}
