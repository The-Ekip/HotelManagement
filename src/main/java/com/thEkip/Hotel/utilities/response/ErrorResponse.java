package com.thEkip.Hotel.utilities.response;




public class ErrorResponse extends Response{
    public ErrorResponse(String message) {
        super(message, false);
    }
}
