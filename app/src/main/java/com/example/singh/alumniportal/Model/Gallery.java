package com.example.singh.alumniportal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery {
    @SerializedName("event_title")
    @Expose
    private String eventTitle;
    @SerializedName("event_date")
    @Expose
    private String eventDate;
    @SerializedName("event_image")
    @Expose
    private String eventImage;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

}