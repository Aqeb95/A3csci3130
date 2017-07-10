package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * class that creates new business contact
 * @author Juliano Franz, Aqeb Hamdan
 */
public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, businessNumberField, addressField, primaryBusinessField, provinceField;
    private MyApplicationData appState;

    /**
     * On create, creates button and edit text fields
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        businessNumberField = (EditText) findViewById(R.id.businessNumber);
        addressField = (EditText) findViewById(R.id.address);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        provinceField = (EditText) findViewById(R.id.province);

    }

    /**
     * submits the info in edit text fields to push update info in the database FireBase
     * @param v View
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String businessNumber = businessNumberField.getText().toString();
        String address = addressField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String province = provinceField.getText().toString();

        Contact person = new Contact(personID, name, businessNumber, address, primaryBusiness, province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
