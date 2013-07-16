/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author gguo
 */
public class Helper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        PrintWriter out = new PrintWriter("C:\\temp\\xml\\output" + ".txt", "UTF-8");//location of output file (thinking of using config

        String parentFolderPath = "C:\\temp\\xml\\";
        String fileName = "col_map.csv";//file to be extracted
        int err_count =0;

        File f = new File(parentFolderPath, fileName);
        if (f.exists()) {
            Scanner scanner = new Scanner(f);
            //read the file line by line...
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                lineNum++;//for debugging
                if (currentLine != null && (!currentLine.trim().isEmpty())) {
                   
                    String[] arr = currentLine.split(",",-1);
                    if (arr.length == 2) {
                        String name = arr[0].trim();
                        String coord = arr[1].trim();

                        out.print("<DestinationColumn>" + "\r");
                        out.print("<name>"+name+"</name>" + "\r");
                        out.print("<description></description>" + "\r");
                        out.print("<source_position>"+coord+"</source_position>" + "\r");
                        out.print("<column_no>"+lineNum+"</column_no>" + "\r");
                        out.print(" </DestinationColumn>" + "\r\r");

                    } else {
                        System.out.println("length not right");
                        err_count++;
                    }
                }

            }
            scanner.close();
            System.out.println(err_count);
        }

        out.close();
    }
}
