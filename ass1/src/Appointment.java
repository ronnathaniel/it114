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
// Filename     : Appointment.java
// Description : This program defines Appointment,
// the container for all appointment-related
// metadata. Metadata is divded up per appointment.
//===================================================

package src;
import java.util.*;


//=================================================
// Appointment - container object for appt metadata
//=================================================
public class Appointment {

    // declare local variables
    String stylistName,
        clientFirstName,
        clientLastName,
        time,
        date;
    Boolean isVerified;

    //=================================================
    // Appointment - default constructor with no params
    //  Input - N/A
    //  Output - the instantiated Appointment
    //=================================================
    public Appointment() {
        this("", "", "", "", "");
    }


    //=================================================
    // Appointment - constructor
    //  Input - all metadata, including the stylist's
    // first name, the client's first and last names,
    // the appt time and date.
    //  Output - the instantiated Appointment
    //=================================================
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


    //=================================================
    // setUnverified - set appointment to Unverified
    // causing the appointment to never be booked.
    // once unverified, irreversable.
    //  Input - the number representing feet to convert
    //  Output - return the equivalent number of meters
    //=================================================
    public void setUnverified() {
        this.isVerified = false;
    }

    //=================================================
    // checkIfVerified - checks if the appointment's should
    // be verified. IF so, it fixes it automatically.
    // Null can be corrected as True, since it was
    // never Unverified until that point.
    // checkIfVerified is called after appt creation
    // but before appointment booking.
    //  Input - N/A
    //  Output - N/A
    //=================================================
    public void checkIfVerified() {
        if (this.isVerified == null) {
            this.isVerified = true;
        }
    }

    //=================================================
    // getOperationStatus - checks appointment's verification
    // status. Status is Up/True if it has not yet been Unverified.
    //  Input - N/A
    //  Output - True if not Unverfied.
    //=================================================
    public boolean getOperationStatus() {
        return this.isVerified != false;
    }

    //=================================================
    // setStylist - set's the appt's Stylist. Checks if
    // that stylist is known.
    //  Input - stylist as the appt's stylist, and
    // allStylists as all known stylists.
    //  Output - N/A
    //=================================================
    public void setStylist(String stylist, List<String> allStylists) {
        this.stylistName = stylist;
        if (!this.verifyStylist(allStylists)) {
            System.out.print("Error: Stylist Unknown. You entered: ");
            System.out.print(stylist + "\n");
            this.setUnverified();
        }
    }

    //=================================================
    // setClientFirstName - set's the appointment's
    // client's first name.
    //  Input - the first name
    //  Output - N/A
    //=================================================
    public void setClientFirstName(String clientFN) {
        if (clientFN.isEmpty()) {
            System.out.print("Error: No First Name was entered: ");
            System.out.println(clientFN + "\n");
            this.setUnverified();
        } else {
            this.clientFirstName = clientFN;
        }
    }

    //=================================================
    // setClientLastName - set's the appointment's
    // client's last name.
    //  Input - the last name
    //  Output - N/A
    //=================================================
    public void setClientLastName(String clientLN) {
        if (clientLN.isEmpty()) {
            System.out.print("Error: No Last Name was entered: ");
            System.out.print(clientLN + "\n");
            this.setUnverified();
        } else {
            this.clientLastName = clientLN;
        }
    }

    //=================================================
    // setDate - set's the appointment's
    // date.
    //  Input - the date as a string. MM/DD/YYYY
    //  Output - N/A
    //=================================================
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

    //=================================================
    // setTime - set's the appointment's
    // time.
    //  Input - the date as a string 24 time. HH:MM
    //  Output - N/A
    //=================================================
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

    //=================================================
    // verifyStylist - internal check to see if the
    // stylist attempted to add is known.
    //  Input - all known stylists
    //  Output - Bool, True if the stylist is known
    //=================================================
    public boolean verifyStylist(List<String> stylists) {
        for (int i = 0; i < stylists.size(); ++i) {
            if (stylists.get(i).equalsIgnoreCase(this.stylistName)) {
                return true;
            }
        }

        System.out.println("Error: No such Stylist exists.");
        return false;
    }

    //=================================================
    // verifyDate - Checks to see if Date is Valid date.
    // can be a past date, for bookeeping purposes.
    //  Input - The date as a Str Arr in 3 parts,
    // MM, DD, and YYYY
    //  Output - Bool, True if the date is valid
    //=================================================
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

    //=================================================
    // verifyTime - Checks to see if Time is Valid time.
    // can be a past date, for bookeeping purposes.
    //  Input - The time as a Str Arr in 2 parts,
    // HH and MM
    //  Output - Bool, True if the time is valid
    //=================================================
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