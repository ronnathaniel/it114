
package ass1;

/*
 * filename: Appointment.java
 * Author: Ron Nathaniel
 * Course: IT 114:452
 *
 */

public class Appointment {

    String stylistFN, clientFN, clientLN, time, date;
    boolean isVerified;

    public Appointment(
        String stylistFN,
        String clientFN,
        String clientLN,
        String time,
        String date
    ) {

        this.stylistFN = stylistFN;
        this.clientFN = clientFN;
        this.clientLN = clientLN;
        this.time = time;
        this.date = date;

    }

    public boolean verifyAppointmentDetails(String[] allStylistFNs) {
        if (!this.verifyStylistExists(allStylistFNs))
            return false;

        if (this.clientFN == "" || this.clientLN == "")
            return false;

        String[] timeParts = this.time.split(":");
        if (timeParts.length != 2) // || timeParts[1].length != 2)
            return false;

        String[] dateParts = this.date.split("/");
        if (dateParts.length != 2) // || dateParts[1].length != 2)
            return false;

        return true;
    }

    public boolean verifyStylistExists(String[] allStylistFNs) {
        for (int i = 0; i < allStylistFNs.length; ++i) {
            if (allStylistFNs[i].equalsIgnoreCase(this.stylistFN)) {
                return true;
            }
        }

        System.out.println("No such Stylist exists.");
        System.out.println(allStylistFNs);
        System.out.println(this.stylistFN);
        return false;
    }

}