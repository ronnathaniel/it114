//===================================================
// Name       : Ron Nathaniel
// SID        : rn328
// Course     : IT 114
// Section    : 452
// Instructor : Professor Deek
// T.A        : N/A
//===================================================
//===================================================
// Assignment # : 1
// Date         : Feb 18 2022
//===================================================
//===================================================
// Filename    : Utils.java
// Description : This program will
//===================================================

package src;
import java.util.*;


//=================================================
// Main - container for Package-wide Utilities
//=================================================
public class Utils {

    //=================================================
    //  fmtQuestion - Formats a query to be fit as a
    // cmd-line question for the user.
    //  Input - original query for user as String
    //  Output - formatted query as String
    //=================================================
    public static String fmtQuestion(String request) {
        request += "? \n->\t";
        return request;
    }

    //=================================================
    //  input - Takes a raw query and sends out a
    // formatted version to the cmd-line for the user,
    // Capturing the response with it.
    //  Input - original query for user as String, and
    // the user's keyboard Scanner
    //  Output - the response from the user.
    //=================================================
    public static String input(String request, Scanner keyboard) {
        request = Utils.fmtQuestion(request);
        System.out.println(request);
        String response = keyboard.nextLine();
        return response;
    }

    //=================================================
    //  inputStrArr - Takes a raw query and sends out a
    // formatted version to the cmd-line for the user,
    // Capturing Multiple responses from the user in
    // response.
    //  Input - original query for user as String.
    //  Output - All multiple responses from the user.
    //=================================================
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