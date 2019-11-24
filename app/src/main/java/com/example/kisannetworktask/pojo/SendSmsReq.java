package com.example.kisannetworktask.pojo;

import java.util.ArrayList;

public class SendSmsReq {


        private String sender;
        private String route;
        private String country;

    public SendSmsReq() {
        this.sms=new ArrayList<>();
    }

    public ArrayList<SMS> getSms() {
        return sms;
    }

    public void setSms(ArrayList<SMS> sms) {
        this.sms = sms;
    }

    ArrayList < SMS > sms = new ArrayList<>();


        // Getter Methods

        public String getSender() {
            return sender;
        }

        public String getRoute() {
            return route;
        }

        public String getCountry() {
            return country;
        }

        // Setter Methods

        public void setSender(String sender) {
            this.sender = sender;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public void setCountry(String country) {
            this.country = country;
        }

}
