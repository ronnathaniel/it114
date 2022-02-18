# Assignment 1

## Receptionist3000: Managed Salon Appointments as a Service

> Author: Ron Nathaniel
> 
> Course: IT 114:452
> 
> Professor: Deek
>

## Table of Contents

- [Goal](#goal)
- [Usage](#usage)
- [Structure](#structure)
- [Development](#development)
- [Technological Debt](#technological-debt)
- [About the Author](#about-the-author)
- [License](#license)
- [Copyright](#copyright)

## Goal

The goal of this project was to create the World's-best Managed Salon. 

Vendor-Agnostic, and one day Globally Distributed are core values that were kept in mind.

## Usage

From Day One, this Project was focused on the End-User Experience.

Fill up to Ten (10) Appointments with your Managed Receptionist.

The Program is extremely interactive, and requires user input from the keyboard interface attached.

Upon invoking the program, the user is greeted by an entry statement.

    Welcome to Receptionist3000. Let's get started.
    Press ENTER to submit answers. For multi-answered questions press ENTER twice.

And it is now time to confiure the Salon. The user will be asked for all Stylists at the Salon.

    Which Styists are currently employed? 
    ->

And then propel the salon to fill all appointments.

    Let's create an Appointment together.

What ensues is a series of questions needed to book an appointment.

    Stylist Name? 
    ->   <STYLIST NAME>      
    

    Client First Name? 
    ->   <FIRST NAME>

    Client Last Name? 
    ->   <LAST NAME>

Enter the Appointment Date in MM/DD/YYYY Form for absolute dates.    

    Date [MONTH/DAY/YEAR] ex: XX/YY/ZZZZ? 
    ->    <MM/DD/YYYY>  

Enter the Appointment Time in HH:MM Form using 24-hour times.

    Time [24h] ex: XX:YY? 
    ->   <HH:MM>

Should all be inputted correctly, the result will show:

    Verified.

Otherwise, an error message indicating failure:

    Could not Verify Appt.

## Structure

    .
    ├── Makefile
    ├── README.md
    └── src/
        ├── Appointment.java        - Appt Structure
        ├── Main.java               - Entry Point 
        ├── Receptionist.java       - Receptionist Figure creating Appts
        └── Utils.java              - IO Operations

## Development

For local development, a [Makefile](/ass1/Makefile) was used for quick testing.

Feel free to update the Makefile to reach greater targets.

## Technologies

No Third-Party tools were used.
Builtins used:

- `java.util.Arraylist` for ad-hoc listing.
- `java.util.Scanner` for user IO.
- 


## Technological Debt

Ideally, this program runs on distributed servers globally, serving users around the world.

In order to achieve this goal, it must be deployed onto a global endpoint, with Load Balancing ensuring that at the very least, 1000 users per second can communicate with Receptionist3000.

## About the Author

The Author and Naarator, Ron, is a self-proclaimed Python Enthusiast. With that said, when possible, He'd prefer to use the most fitting technologies per project, as opposed to choosing based off of personal favoritism.

The Author and Naarator enjoyed this project immensely, and would do so again in a heartbeat.
## Copyright

All Rights Reserved.