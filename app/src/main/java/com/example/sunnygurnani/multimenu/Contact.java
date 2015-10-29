package com.example.sunnygurnani.multimenu;

/**
 * Created by sunnygurnani on 7/7/15.
 */
public class Contact {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name_user1) {
        this.firstName = name_user1;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String contactnumber1) {
        this.phoneNumber = contactnumber1;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String email_id_1) {
        this.emailAddress = email_id_1;
    }

    private String firstName;
    private String phoneNumber;
    private String emailAddress;

}