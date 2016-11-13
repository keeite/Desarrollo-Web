/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.beans.implementation;

/**
 *
 * @author Dani
 */
public class ReplyBean {
    private int status;
    private String json;
    
    public ReplyBean(int status,String json){
        this.status = status;
        this.json = json;
    }

    public int getStatus() {
        return status;
    }

    public String getJson() {
        return json;
    }
    
    
}
