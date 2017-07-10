package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**class that updates and erases business contact
 * @author Juliano Franz, Aqeb Hamdan
 */
public class DetailViewActivity extends Activity {

    private EditText nameField, businessNumberField, addressField, primaryBusinessField, provinceField;
    Contact receivedPersonInfo;
    String key;

    /**
     * creates buttons and edit text fields on start. Sets information if not empty
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");


        nameField = (EditText) findViewById(R.id.name);
        businessNumberField = (EditText) findViewById(R.id.businessNumber);
        addressField = (EditText) findViewById(R.id.address);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            businessNumberField.setText(receivedPersonInfo.businessNumber);
            addressField.setText(receivedPersonInfo.address);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            provinceField.setText(receivedPersonInfo.province);
            key = receivedPersonInfo.uid;

        }
    }

    /**
     *  Updates the existing contact information in the database FireBase
     * @param v View
     */

    public void updateContact(View v){
        String name = nameField.getText().toString();
        String businessNumber = businessNumberField.getText().toString();
        String address = addressField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String province = provinceField.getText().toString();

        Contact person = new Contact(key, name, businessNumber, address, primaryBusiness, province);
        DatabaseReference db_node = FirebaseDatabase.getInstance().getReference().getRoot().child("contacts").child(key);
        db_node.setValue(person);
        finish();

    }

    /**
     *Erases the contact from fireBase
     * @param v View
     */
    public void eraseContact(View v)
    {
        DatabaseReference db_node = FirebaseDatabase.getInstance().getReference().getRoot().child("contacts").child(key);
        db_node.removeValue();
        finish();
    }
}
