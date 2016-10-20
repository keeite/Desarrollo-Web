/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.model;

import java.sql.Date;

/**
 *
 * @author Dani
 */
public class Pedido {
    private int id,amountItems;
    private float totalPrice;
    private java.sql.Date date;
    

    public Pedido(int id,int amountItems,float totalPrice,java.sql.Date date){
        this.id = id;
        this.amountItems = amountItems;
        this.totalPrice = totalPrice;
        this.date = date;
        
    }
    public int getId() {
        return id;
    }

    public int getAmountItems() {
        return amountItems;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public Date getDate() {
        return date;
    }
    
    
    
}
