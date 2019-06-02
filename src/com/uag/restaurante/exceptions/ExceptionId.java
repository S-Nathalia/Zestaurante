
package com.uag.restaurante.exceptions;

public class ExceptionId extends Exception{
    private String message;

    public ExceptionId(String message) {
        super();
        this.message = message;
        System.out.println(message);
    }   
}
