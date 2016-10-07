/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carritomaven.control;

import java.util.ArrayList;
import com.mycompany.carritomaven.model.Producto;
/**
 *
 * @author Dani
 */
public class Carro extends ArrayList<Producto> {  
    
    public String getJson(){
        String json = "{\"Status\" : 200, \"Message\" : [";
        
        for(int i = 0; i < this.size(); i++){
            json += i == this.size() - 1 ? this.get(i).getJson(): this.get(i).getJson() + "," ;   
        }
        json += "]}";
        return json;
    }
    
    public String getJsonPurchases(){
        String json = "[";
        
        for(int i = 0; i < this.size(); i++){
            json += i == this.size() - 1 ? this.get(i).getJson(): this.get(i).getJson() + "," ;   
        }
        json += "]";
        return json;
    }
    
    
}
