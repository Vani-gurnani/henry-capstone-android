package com.example.sunnygurnani.multimenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationContactActivity extends Activity {


    ViewPager mViewPager;
    Contact contact = new Contact();
    String serviceUrl = "https://rocky-falls-3529.herokuapp.com/person";
    String mobileId = null;
    RequestQueue queue = null;
    public void saveContactStore(){


        if(mobileId != null)
            contact.set_id(mobileId);
        Gson gson = new Gson();
        String data = gson.toJson(contact);
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(data);
            final Activity activity = this;
            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.POST, serviceUrl + "/" + mobileId, jsonObj, new Response.Listener<JSONObject>() {



                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                System.out.println("Successful response received from Save Person service "+ response.toString());
                                mobileId = response.getString("_id");

                                CommonHelper.setMobileId(activity, mobileId);
                                setMobileIdInView(mobileId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("Error received from Save Person service "+ error.toString());
                            // TODO Auto-generated method stub

                        }
                    });


            queue.add(jsObjRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    public void GetContactFromFromService(){

        if(mobileId != null) {
            JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, serviceUrl + "/" + mobileId, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response != null) {
                            if(response.has("MobileNumber"))
                                contact.setMobileNumber(response.getString("MobileNumber"));
                            //contact.setEmailAddress(response.getString("EmailAddress"));
                            if(response.has("Firstname"))
                                contact.setFirstname(response.getString("Firstname"));
                            if(response.has("Lastname"))
                                contact.setLastname(response.getString("Lastname"));
                            if(response.has("_id"))
                                contact.set_id(response.getString("_id"));
                            setContactInView(contact);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(jsonRequest);
        }
    }

    void setContactInView(Contact contact){
        EditText fname = (EditText)findViewById(R.id.fname_user);
        fname.setText(contact.getFirstname());

        EditText lname = (EditText)findViewById(R.id.lname_user);
        lname.setText(contact.getLastname());

        EditText email = (EditText)findViewById(R.id.email_user);
        email.setText(contact.getEmailAddress());

        EditText phoneNumber = (EditText)findViewById(R.id.phone_user);
        phoneNumber.setText(contact.getMobileNumber());

    }

    void getContactFromView(Contact contact){
        EditText fname = (EditText)findViewById(R.id.fname_user);
        contact.setFirstname(fname.getText().toString());

        EditText lname = (EditText)findViewById(R.id.lname_user);
        contact.setLastname(lname.getText().toString());

        EditText email = (EditText)findViewById(R.id.email_user);
        contact.setEmailAddress(email.getText().toString());

        EditText phoneNumber = (EditText)findViewById(R.id.phone_user);
        contact.setMobileNumber(phoneNumber.getText().toString());

    }

    protected void setMobileIdInView(String mobileId){
        TextView mobile = (TextView)findViewById(R.id.mobileId);
        mobile.setText(mobileId);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration_contact);
        this.mobileId = CommonHelper.getMobileId(this);
        queue = Volley.newRequestQueue(this);
        ((Button)findViewById(R.id.save_user)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContactFromView(contact);
                saveContactStore();

            }
        });

        setMobileIdInView(mobileId);
        GetContactFromFromService();



        //mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager(), contactStore);

//        // Set up the ViewPager with the sections adapter.
//        mViewPager = (ViewPager) findViewById(R.id.pager);
//        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
//        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                actionBar.setSelectedNavigationItem(position);
//            }
//        });


    }





}
