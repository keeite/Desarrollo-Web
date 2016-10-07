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
public class Rows {
    private List<Row> rows = new ArrayList<>();
    
    public void addRow(Row row){
        rows.add(row);
    }
}
