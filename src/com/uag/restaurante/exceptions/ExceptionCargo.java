
package com.uag.restaurante.exceptions;

public class ExceptionCargo extends Exception{
    private String str;
    
    public ExceptionCargo(String str) {
        super();
        this.str = str;
    }
}
   