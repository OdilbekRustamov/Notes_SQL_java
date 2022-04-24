package com.example.notessqljava.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.notessqljava.model.Note;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes_db";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Note.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Note.TABLE_NAME);
        onCreate(db);
    }
    public Note getNote(long id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Note.TABLE_NAME,
                new String[]{Note.COLUMB_ID, Note.COLUMB_NOTE, Note.COLUMB_TIMESTAMP},
                Note.COLUMB_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
       if (cursor != null)
           cursor.moveToFirst();

       @SuppressLint("Range") Note note = new Note(
               cursor.getInt(cursor.getColumnIndex(Note.COLUMB_ID)),
               cursor.getString(cursor.getColumnIndex(Note.COLUMB_NOTE)),
               cursor.getString(cursor.getColumnIndex(Note.COLUMB_TIMESTAMP)));

               cursor.close();
               return note;
    }
    @SuppressLint("Range")
    public List<Note> getAllNotes(){
        List<Note> notes = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + Note.TABLE_NAME + " ORDER BY " +
                Note.COLUMB_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(Note.COLUMB_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(Note.COLUMB_NOTE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Note.COLUMB_TIMESTAMP)));
                notes.add(note);
            }while (cursor.moveToFirst());
        }
        db.close();
        return notes;
    }
    public int getNotesCount(){
        String countQuary = "SELECT * FROM " + Note.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuary, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public int updateNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Note.COLUMB_NOTE, note.getNote());

        return db.update(Note.TABLE_NAME, values, Note.COLUMB_ID + " =?",
                new String[]{String.valueOf(note.getId())});
    }
    public void deleteNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Note.TABLE_NAME, Note.COLUMB_NOTE + " =?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
}
