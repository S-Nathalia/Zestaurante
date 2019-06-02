/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools || Templates
 * and open the template in the editor.
 */
package com.uag.restaurante.exceptions;

/**
 *
 * @author Nathalia
 */
public class ExceptionDataNasc extends Exception{
    private String str;
    
    public ExceptionDataNasc(String str) {
        super();
        this.str = str;
    }

}