
package com.uag.restaurante.exceptions;

public class ExceptionTelefoneInvalido extends Exception{
    private String str;

    public ExceptionTelefoneInvalido(String str) {
        super();
        this.str = str;
    }

}
