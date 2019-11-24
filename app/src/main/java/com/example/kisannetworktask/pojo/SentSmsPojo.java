package com.example.kisannetworktask.pojo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "sent_msgs")
public class SentSmsPojo implements Serializable {


    private String firstName;

    private String lastName;
    @NonNull
    @PrimaryKey
    private String contact;

    public SentSmsPojo(@NonNull String firstName, String lastName, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}

/*package com.example.kisannetworktask.pojo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "contacts")
public class ContactPojo implements Serializable {

    @NonNull
    @PrimaryKey

    private String firstName;

    private String lastName;

    private String contact;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ContactPojo(String firstName, String lastName, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }
}

*/