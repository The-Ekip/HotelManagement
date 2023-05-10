package com.thEkip.Hotel.exceptionHandler.hotelExceptions;

public class BusinessRuleException extends  RuntimeException{
    public BusinessRuleException(){
        super("Business Rule Exception");
    }
    public BusinessRuleException(String message){
        super(message);
    }
}
