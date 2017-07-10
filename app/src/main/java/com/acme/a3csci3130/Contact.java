package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 * @author Juliano Franz, Aqeb Hamdan
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name, businessNumber, address, primaryBusiness, province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * info variables for business contact
     * @param uid
     * @param name
     * @param businessNumber
     * @param address
     * @param primaryBusiness
     * @param province
     */
    public Contact(String uid, String name, String businessNumber, String address, String primaryBusiness, String province){
        this.uid = uid;
        this.name = name;
        this.businessNumber = businessNumber;
        this.address = address;
        this.primaryBusiness = primaryBusiness;
        this.province = province;
    }

    /**
     * not used
     * @return Hashmap
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", businessNumber);
        result.put("email", address);
        result.put("email", primaryBusiness);
        result.put("email", province);

        return result;
    }
}
