/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author blank
 */
public class datetime {

    public String getTime()

    {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date dateobj = new Date();

        String dt = df.format(dateobj);
        return dt;
    }
    public String getDate()

    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateobj = new Date();

        String dt = df.format(dateobj);
        return dt;
    }
    
}