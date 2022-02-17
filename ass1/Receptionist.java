
package ass1;
import java.util.Scanner;

/*
 * filename: Receptionist.java
 * Author: Ron Nathaniel
 * Course: IT 114:452
 *
 */


public class Receptionist {

    String[] stylists;
    Scanner keyboard = new Scanner(System.in);


    public Receptionist() {
        this.stylists = new String[10];
    }

    public void setStylists(String[] stylists) {
        this.stylists = stylists;
    }

    public void createAppointment() {
        System.out.println("Stylist Name? ");
        String stylistName = this.keyboard.nextLine();

        System.out.println("Client First Name? ");
        String clientFN = this.keyboard.nextLine();

        System.out.println("Client Last Name? ");
        String clientLN = this.keyboard.nextLine();

        System.out.println("Time? ");
        String time = this.keyboard.nextLine();

        System.out.println("Date? ");
        String date = this.keyboard.nextLine();

        Appointment clientAppt = new Appointment(
            stylistName, clientFN, clientLN, time, date
        );

        if (! clientAppt.verifyAppointmentDetails(this.stylists)) {
            System.out.println("Appt Cancelled.");
        }
    }

}