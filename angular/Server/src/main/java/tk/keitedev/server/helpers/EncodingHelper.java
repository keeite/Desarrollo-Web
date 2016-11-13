/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author Dani
 */
public class EncodingHelper {
    public static String decodeURIComponent(String s) throws UnsupportedEncodingException {
        return s == null ? null: URLDecoder.decode(s, "UTF-8");  
    }
}
