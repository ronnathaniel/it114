
/*
 * filename: Receptionist.java
 * Author: Ron Nathaniel
 * Course: IT 114:452
 *
 */

package src;
import java.util.*;


public class Receptionist {

    List<String> stylists;
    List<Appointment> appts;
    Scanner keyboard = new Scanner(System.in);


    public Receptionist() {
        appts = new ArrayList<Appointment>();

        System.out.println("\n\rWelcome to Receptionist3000. Let's get started.");
        System.out.println("Press ENTER to submit answers. For multi-answered questions press ENTER twice.");
        this.stylists = Utils.inputStrArr("Which Styists are currently employed", keyboard);
        System.out.print("You entered: ");
        System.out.print(this.stylists + "\n");
    }


    public void createAppointment() {
        boolean validatedStylist, validatedClientFN, validatedClientLN, validatedDate, validatedTime;
        Appointment clientAppt = new Appointment();

        System.out.println("Let's create an Appointment together.");
        String stylistName = Utils.input("Stylist Name", this.keyboard);
        clientAppt.setStylist(stylistName, this.stylists);

        String clientFN = Utils.input("Client First Name", this.keyboard);
        clientAppt.setClientFirstName(clientFN);

        String clientLN = Utils.input("Client Last Name", this.keyboard);
        clientAppt.setClientLastName(clientLN);

        String date = Utils.input("Date [MONTH/DAY/YEAR] ex: XX/YY/ZZZZ", this.keyboard);
        clientAppt.setDate(date);

        String time = Utils.input("Time [24h] ex: XX:YY", this.keyboard);
        clientAppt.setTime(time);

        clientAppt.checkIfVerified();
        if (clientAppt.isVerified) {
            System.out.println("Verified.");

            appts.add(clientAppt);
        } else {
            System.out.println("Could not Verify Appt.");
        }
}