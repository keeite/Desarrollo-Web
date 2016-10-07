/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.usandojquery.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani
 */
public class Row {
    private List<Integer> cols;
    
    public Row(){
        cols = new ArrayList<>();
    }
    
    public void addCol(int num){
        cols.add(num);
    }
}
