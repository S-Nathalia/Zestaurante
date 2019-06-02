
package com.uag.restaurante.exceptions;

public class ExceptionAcessarCaixa extends Exception{
    private String str;
    
    public ExceptionAcessarCaixa(String aaa) {
        super();
        this.str = aaa;
    }
    
}
   