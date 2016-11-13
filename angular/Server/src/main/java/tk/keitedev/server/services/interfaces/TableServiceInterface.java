/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.services.interfaces;

import tk.keitedev.server.beans.implementation.ReplyBean;

/**
 *
 * @author Dani
 */
public interface TableServiceInterface {
    
    public ReplyBean get() throws Exception;
    public ReplyBean remove() throws Exception;
    public ReplyBean set() throws Exception;
}
