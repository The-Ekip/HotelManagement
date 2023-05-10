package com.thEkip.Hotel.utilities.response;

import lombok.Data;

@Data
public class Response {
    private String message;
    private boolean isSuccess;
    public Response(String message,boolean isSuccess){
        this.message=message;
        this.isSuccess=isSuccess;
    }
}
