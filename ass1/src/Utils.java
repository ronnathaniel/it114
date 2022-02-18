
/*
 * filename: Utils.java
 * Author: Ron Nathaniel
 * Course: IT 114:452
 * Professor: Deek
 */

package src;
import java.util.*;


public class Utils {

    public static String fmtQuestion(String request) {
        request += "? \n->\t";
        return request;
    }

    public static String input(String request, Scanner keyboard) {
        request = Utils.fmtQuestion(request);
        System.out.println(request);
        String response = keyboard.nextLine();
        return response;
    }

    public static List<String> inputStrArr(String request, Scanner keyboard) {
        request = Utils.fmtQuestion(request);
        System.out.println(request);
        List responses = new ArrayList<String>();

        for (
            String r = keyboard.nextLine();
            !r.isEmpty();
            r = keyboard.nextLine()
        ) {
            responses.add(r);
        }

        return responses;
    }

}