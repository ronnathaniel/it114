
/*
 * filename: Main.java
 * Author: Ron Nathaniel
 * Course: IT 114:452
 *
 */

package src;
import java.util.*;

/**
 * The type Main. Entry Point for the Process.
 */
public class Main {

    /**
     * The entry point of application.
     * Runs indefinitely until 10 Appts have been submitted.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    Receptionist r = new Receptionist();

    while (appts.size() < 10)
        r.createAppointment();

    }
}

