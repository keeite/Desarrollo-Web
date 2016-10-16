/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.model;

/**
 *
 * @author a044887852v
 */
public class Producto {
    private int id,amount;
    private float price;
    private String desc;
    
    public Producto(int id,String desc,int amount,float price){
        this.id = id;
        this.amount = amount;
        this.desc = desc;
        this.price = price;
    }
    public Producto(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAmount() {
        return amount;
    }

    public String getDesc() {
        return desc;
    }
    
    public float getPrice(){
        return price;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
       
    public Producto clone(){ 
        return new Producto(id,desc,amount,price);
    }
}
