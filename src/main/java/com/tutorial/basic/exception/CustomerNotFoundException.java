package com.tutorial.basic.exception;
 //vd020
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message){
        super(message);
    }
}
