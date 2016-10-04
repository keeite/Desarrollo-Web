/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.control;

import java.util.ArrayList;
import net.ausiasmarch.carritogson.model.Producto;

/**
 *
 * @author Dani
 */
public class Stock extends ArrayList<Producto> {
    
    public Stock(){
        this.add(new Producto(1,"piruleta",20,11));
        this.add(new Producto(2,"caramelo",10,3));
        this.add(new Producto(3,"chupachups",15,5));
        this.add(new Producto(4,"galletas",30,6));
        this.add(new Producto(5,"chicles",45,1));
        this.add(new Producto(6,"agua",3,1));        
    }
}
