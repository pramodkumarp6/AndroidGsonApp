package com.example.androidgsonapp.utils;

public class ApiResponse <T>{

    private T data;
    private String message;
    private boolean success;


    public ApiResponse(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }
    public T getData() {
        return data;
    }

}
