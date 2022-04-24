package com.example.notessqljava.model;

public class Note {
    public static final String TABLE_NAME = "notes";
    public static final String COLUMB_ID = "id";
    public static final String COLUMB_NOTE = "note";
    public static final String COLUMB_TIMESTAMP = "timestamp";

    private int id;
    private String note;
    private String timestamp;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
            + COLUMB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMB_NOTE + " TEXT,"
            + COLUMB_TIMESTAMP + "DATETIME DEFAULT CURRENT_TIMESTAMP"
            + ")";
    public Note(){
    }

    public Note(int id, String note, String timestamp){
        this.id = id;
        this.note = note;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
