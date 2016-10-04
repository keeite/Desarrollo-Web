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
    private int id,amount,price;
    private String desc;
    
    public Producto(int id,String desc,int amount,int price){
        this.id = id;
        this.amount = amount;
        this.desc = desc;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getDesc() {
        return desc;
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getJsonMin(){      
        return "{\"id\":" + id +", \"amount\": " + amount + "}";
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getJson(){      
        return "{\n\t\"id\":" + id + ",\n\t\"desc\":\"" + desc + "\",\n\t\"amount\":" + amount + ",\n\t\"price\":" + price + "\n}";
    }
    public Producto clone(){ 
        return new Producto(id,desc,amount,price);
    }
}
