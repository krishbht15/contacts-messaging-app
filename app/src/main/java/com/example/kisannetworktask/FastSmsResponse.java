package com.example.kisannetworktask;

import java.util.ArrayList;

public class FastSmsResponse {
//    private boolean return;
    private String request_id;
    ArrayList< String  > message ;

    public FastSmsResponse() {
        this.message=new ArrayList < > ();
    }
// Getter Methods

//    public boolean getReturn() {
//        return return;
//    }

    public String getRequest_id() {
        return request_id;
    }

    // Setter Methods

//    public void setReturn(boolean
//  return) {
//        this.return =
//        return;
//    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
}
