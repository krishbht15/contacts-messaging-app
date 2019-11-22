package com.example.kisannetworktask.pojo;

public class MessageResponse {
    private String account_sid;
    private String api_version;
    private String body;
    private String date_created;
    private String date_sent;
    private String date_updated;
    private String direction;
    private String error_code = null;
    private String error_message = null;
    private String from;
    private String messaging_service_sid = null;
    private String num_media;
    private String num_segments;
    private String price = null;
    private String price_unit = null;
    private String sid;
    private String status;
    SubresourceUrisPojo Subresource_urisObject;
    private String to;
    private String uri;


    // Getter Methods

    public String getAccount_sid() {
        return account_sid;
    }

    public String getApi_version() {
        return api_version;
    }

    public String getBody() {
        return body;
    }

    public String getDate_created() {
        return date_created;
    }

    public String getDate_sent() {
        return date_sent;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public String getDirection() {
        return direction;
    }

    public String getError_code() {
        return error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public String getFrom() {
        return from;
    }

    public String getMessaging_service_sid() {
        return messaging_service_sid;
    }

    public String getNum_media() {
        return num_media;
    }

    public String getNum_segments() {
        return num_segments;
    }

    public String getPrice() {
        return price;
    }

    public String getPrice_unit() {
        return price_unit;
    }

    public String getSid() {
        return sid;
    }

    public String getStatus() {
        return status;
    }

    public SubresourceUrisPojo getSubresource_uris() {
        return Subresource_urisObject;
    }

    public String getTo() {
        return to;
    }

    public String getUri() {
        return uri;
    }

    // Setter Methods

    public void setAccount_sid(String account_sid) {
        this.account_sid = account_sid;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public void setDate_sent(String date_sent) {
        this.date_sent = date_sent;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMessaging_service_sid(String messaging_service_sid) {
        this.messaging_service_sid = messaging_service_sid;
    }

    public void setNum_media(String num_media) {
        this.num_media = num_media;
    }

    public void setNum_segments(String num_segments) {
        this.num_segments = num_segments;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPrice_unit(String price_unit) {
        this.price_unit = price_unit;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSubresource_uris(SubresourceUrisPojo subresource_urisObject) {
        this.Subresource_urisObject = subresource_urisObject;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}

