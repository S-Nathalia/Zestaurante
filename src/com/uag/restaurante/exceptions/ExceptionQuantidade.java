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
public class ExceptionQuantidade extends Exception{
    private String message;

    public ExceptionQuantidade(String message) {
        super();
        this.message = message;
        System.out.println(message);
    }
}
