/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gguo
 */
public class timeconverter {

    public String convertTime(String timein, String informat, String outformat) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat(informat);

        Date dt = new Date();
        try {
            dt = sdf.parse(timein);

            SimpleDateFormat sdfout = new SimpleDateFormat(outformat);
            result = sdfout.format(dt);
            return  result;
        } catch (ParseException ex) {
            Logger.getLogger(timeconverter.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;
    }
}
