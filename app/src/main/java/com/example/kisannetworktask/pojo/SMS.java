package com.example.kisannetworktask.pojo;

import java.util.ArrayList;

public class SMS {

        private String message;

    public ArrayList<String> getTo() {
        return to;
    }

    public void setTo(ArrayList<String> to) {
        this.to = to;
    }

    public SMS() {
        this.to=new ArrayList<>();
    }

    ArrayList< String  > to = new ArrayList <> ();


        // Getter Methods

        public String getMessage() {
            return message;
        }

        // Setter Methods

        public void setMessage(String message) {
            this.message = message;
        }

}
