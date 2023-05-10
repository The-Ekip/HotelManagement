package com.thEkip.Hotel.utilities.response;

import lombok.Data;

@Data
public class SuccessDataResponse<T> extends Response{

    public SuccessDataResponse(String message,T data){
        super(message,true);
        this.data=data;
    }
    private T data;
}
