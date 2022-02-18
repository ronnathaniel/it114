
/*
 * filename: Appointment.java
 * Author: Ron Nathaniel
 * Course: IT 114:452
 *
 */

package src;
import java.util.*;


public class Appointment {

    String stylistName,
        clientFirstName,
        clientLastName,
        time,
        date;
    Boolean isVerified;

    public Appointment() {
        this("", "", "", "", "");
    }

    public Appointment(
        String stylistN,
        String clientFN,
        String clientLN,
        String time,
        String date
    ) {
        this.stylistName = stylistN;
        this.clientFirstName = clientFN;
        this.clientLastName = clientLN;
        this.time = time;
        this.date = date;
        this.isVerified = null;
    }


    public void setUnverified() {
        this.isVerified = false;
    }

    public void checkIfVerified() {
        if (this.isVerified == null) {
            this.isVerified = true;
        }
    }

    public boolean getOperationStatus() {
        return this.isVerified != false;
    }

    public void setStylist(String stylist, List<String> allStylists) {
        this.stylistName = stylist;
        if (!this.verifyStylist(allStylists)) {
            System.out.print("Error: Stylist Unknown. You entered: ");
            System.out.print(stylist + "\n");
            this.setUnverified();
        }
    }

    public void setClientFirstName(String clientFN) {
        if (clientFN.isEmpty()) {
            System.out.print("Error: No First Name was entered: ");
            System.out.println(clientFN + "\n");
            this.setUnverified();
        } else {
            this.clientFirstName = clientFN;
        }
    }

    public void setClientLastName(String clientLN) {
        if (clientLN.isEmpty()) {
            System.out.print("Error: No Last Name was entered: ");
            System.out.print(clientLN + "\n");
            this.setUnverified();
        } else {
            this.clientLastName = clientLN;
        }
    }

    public void setDate(String apptDate) {
        if (apptDate.isEmpty()) {
            System.out.println("Error: No Date was entered.");
            this.setUnverified();
        }
        String[] dateSplit = apptDate.split("/");
        if (this.verifyDate(dateSplit)) {
            this.date = apptDate;
        } else {
            System.out.print("Error: Could not confirm date: ");
            System.out.print(apptDate + "\n");
            this.setUnverified();
        }
    }

    public void setTime(String apptTime) {
        if (apptTime.isEmpty()) {
            System.out.println("Error: No Time was entered.");
            this.setUnverified();
        }
        String[] timeSplit = apptTime.split(":");
        if (this.verifyTime(timeSplit)) {
            this.time = apptTime;
        } else {
            System.out.print("Error: Could not confirm time: ");
            System.out.print(apptTime + "\n");
            this.setUnverified();
        }
    }

    public boolean verifyStylist(List<String> stylists) {
        for (int i = 0; i < stylists.size(); ++i) {
            if (stylists.get(i).equalsIgnoreCase(this.stylistName)) {
                return true;
            }
        }

        System.out.println("Error: No such Stylist exists.");
        return false;
    }

    public boolean verifyDate(String[] dateSplit) {
        if (dateSplit.length != 3) {
            return false;
        }
        for (int i = 0; i < dateSplit.length; ++i) {
            try {
                Integer.parseInt(dateSplit[i]);
            } catch (NumberFormatException e) {
                System.out.print("Error: Not a correct Date segment: ");
                System.out.println(dateSplit[i] + "\n");
                return false;
            }

            if (
                (i < 2 && dateSplit[i].length() != 2)
            ||
                (i == 0 && Integer.parseInt(dateSplit[i]) > 12)
            ||
                (i == 1 && Integer.parseInt(dateSplit[i]) > 31)
            ||
                (i == 2 && new Date().getYear() > Integer.parseInt(dateSplit[i]))
            ||
                (i == 2 && dateSplit[i].length() != 4)
            ) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyTime(String[] timeSplit) {
        if (timeSplit.length != 2) {
            return false;
        }

        for (int i = 0; i < timeSplit.length; ++i) {
            try {
                Integer.parseInt(timeSplit[i]);
            } catch (NumberFormatException e) {
                System.out.print("Error: Not a correct Time segment: ");
                System.out.println(timeSplit[i] + "\n");
                return false;
            }

            if (
                (timeSplit[i].length() != 2)
            ||
                (i == 0 && Integer.parseInt(timeSplit[i]) > 24)
            ||
                (i == 1 && Integer.parseInt(timeSplit[i]) > 59)
            ) {
                return false;
            }
        }
        return true;
    }

}