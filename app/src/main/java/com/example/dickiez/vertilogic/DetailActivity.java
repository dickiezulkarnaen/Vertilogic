package com.example.dickiez.vertilogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dickiez.vertilogic.Model.Address;
import com.example.dickiez.vertilogic.Model.Company;
import com.example.dickiez.vertilogic.Model.User;
import com.google.gson.GsonBuilder;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView txtUsername;
    TextView txtEmail;
    TextView txtPhone;
    TextView txtWebsite;
    TextView txtCompName;
    TextView txtDesc;
    TextView txtSubdesc;
    TextView txtStreet;
    TextView txtSuite;
    TextView txtCity;
    TextView txtZipcode;

    User listUser;
    Company company;
    Address address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtUsername = (TextView) findViewById(R.id.txt_det_username);
        txtEmail = (TextView) findViewById(R.id.txt_det_email);
        txtPhone = (TextView) findViewById(R.id.txt_det_phone);
        txtWebsite = (TextView) findViewById(R.id.txt_det_website);
        txtCompName = (TextView) findViewById(R.id.txt_company_name);
        txtDesc = (TextView) findViewById(R.id.txt_desc);
        txtSubdesc = (TextView) findViewById(R.id.txt_subdesc);
        txtStreet = (TextView)findViewById(R.id.txt_street);
        txtSuite = (TextView)findViewById(R.id.txt_suite);
        txtCity = (TextView)findViewById(R.id.txt_city);
        txtZipcode = (TextView)findViewById(R.id.txt_zipcode);

        listUser = new GsonBuilder().create()
                .fromJson(getIntent().getStringExtra("user"), User.class);

        company = listUser.getCompany();
        address = listUser.getAddress();

        txtUsername.setText(listUser.getUsername());
        txtEmail.setText(listUser.getEmail());
        txtPhone.setText(listUser.getPhone());
        txtWebsite.setText(listUser.getWebsite());

        txtCompName.setText(company.getName());
        txtDesc.setText(company.getCatchPhrase());
        txtSubdesc.setText(company.getBs());
        txtStreet.setText(address.getStreet());
        txtSuite.setText(address.getSuite());
        txtCity.setText(address.getCity());
        txtZipcode.setText(address.getZipcode());

    }
}
