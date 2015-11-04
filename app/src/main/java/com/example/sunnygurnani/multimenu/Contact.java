package com.example.sunnygurnani.multimenu;

/**
 * Created by sunnygurnani on 7/7/15.
 */
public class Contact {

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String fname_user) {
        this.Firstname = fname_user;
    }
    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lname_user) {
        this.Lastname = lname_user;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String contactnumber1) {
        this.mobileNumber = contactnumber1;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String email_id_1) {
        this.emailAddress = email_id_1;
    }


    public void set_id(String _id){
        this._id = _id;
    }
    public String get_id(){
        return this._id;
    }


    private String Firstname;
    private String Lastname;
    private String mobileNumber;
    private String emailAddress;
    private String _id;

}