package com.example.listviewactionbarmenuapp;

public class CanberraEvent {

    String title;
    int imageResource;
    String dates;

    public CanberraEvent(String title,int imageResource, String dates)
    {
        this.title = title;
        this.imageResource = imageResource;
        this.dates = dates;

    }

    public String getTitle()
    {
        return this.title;
    }

    public int getImageResource()
    {
        return this.imageResource;
    }

    public String getDates()
    {
        return this.dates;
    }

    public String toString() { return this.title;}

}
