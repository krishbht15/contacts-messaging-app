package com.example.kisannetworktask;

import java.util.ArrayList;

public class FastSmsPojo {
    String authorization;
    String sender_id;
    String message;
    String language;
    String route;
    ArrayList<String> numbers;

    public FastSmsPojo() {
        this.numbers=new ArrayList<>();
        this.sender_id="FSTSMS";
        this.authorization="drBUuYvcAqKfbelR6NhiwZQyWmgkIxznXp1J2FjL9aHG8O3S7T48ikldrPCUcVJL3v5aYDo9wzjQZuTA";
        this.language="english";
        this.route="p";
        numbers.add("7838238498");
    }


//    public String getAuthorization() {
//        return authorization;
//    }
//
//    public void setAuthorization(String authorization) {
//        this.authorization = authorization;
//    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
    }
}

/*authorization	true	Provide "YOUR_API_KEY". Sign up for API Key
sender_id	true	"FSTSMS" is the default sender id, you can create your own custom 6 digit sender id on Fast2SMS.
message	true	Message "text" to be sent
language	true	Default language is "english". You can use "unicode" for other languages
route	true	For promotional use "p" & For transactional use "t"
numbers	true	You can send multiple mobile numbers seperated by comma like: "8888888888,9999999999,6666666666"*/