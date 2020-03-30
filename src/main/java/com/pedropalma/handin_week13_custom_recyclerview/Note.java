package com.pedropalma.handin_week13_custom_recyclerview;
public class Note {
    private String id;
    private String title;
    private String Description;

    public Note(String id, String title, String description) {
        this.id=id;
        this.title = title;
        Description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
