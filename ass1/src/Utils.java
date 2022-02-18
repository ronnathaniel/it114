
/*
 * filename: Utils.java
 * Author: Ron Nathaniel
 * Course: IT 114:452
 * Professor: Deek
 */

package src;
import java.util.*;


/**
 * The type Utils.
 */
public class Utils {

    /**
     * Fmt Strings to pose as a Question.
     *
     * @param request the request
     * @return the string
     */
    public static String fmtQuestion(String request) {
        request += "? \n->\t";
        return request;
    }

    /**
     * Input String.
     *
     * @param request  the request
     * @param keyboard the keyboard
     * @return the string
     */
    public static String input(String request, Scanner keyboard) {
        request = Utils.fmtQuestion(request);
        System.out.println(request);
        String response = keyboard.nextLine();
        return response;
    }

    /**
     * Input String List.
     *
     * @param request  the request
     * @param keyboard the keyboard
     * @return the list
     */
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