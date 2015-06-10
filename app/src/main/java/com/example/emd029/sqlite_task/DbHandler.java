package com.example.emd029.sqlite_task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by EMD029 on 6/1/2015.
 */
public class DbHandler extends SQLiteOpenHelper {
    static String col;
    ArrayList<String> namesList = new ArrayList<String>();
    //table,database names
    static final String DATABASE_NAME = "StudentDB";
    static final String TABLE_NAME = "Sqllite Task";
    static final int DATABASE_VERSION = 1;
    //column names
    static final String COLUMN_ID = "id";
    static final String COLUMN_NAME = "COLUMN_NAME";
    static final String COLUMN_SUBJECT = "subject";
    static final String COLUMN_ASSIGNMENTTASK = "assignmenttask";
    Context context;

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creating database
        sqLiteDatabase.execSQL("CREATE TABLE TABLE_NAME ( COLUMN_ID INTEGER PRIMARY KEY, COLUMN_NAME TEXT, COLUMN_SUBJECT TEXT," +
                " COLUMN_ASSIGNMENTTASK TEXT)");
        // Toast.makeText(context,"table created",Toast.LENGTH_LONG).show();
        Log.d("DB", "Students Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        //upgrade database
        sqLiteDatabase.execSQL("Drop Table If Exists" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addName(StudentNames names) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues insertvalues = new ContentValues();
            //insertvalues.put("COLUMN_ID", names.getId());
            insertvalues.put("COLUMN_NAME", names.getName());
            insertvalues.put("COLUMN_SUBJECT", names.getSubject());
            insertvalues.put("COLUMN_ASSIGNMENTTASK", names.getAssignmentTask());
            db.insert("TABLE_NAME", null, insertvalues);
            db.close();
            //  Toast.makeText(context, insertvalues.toString(),Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<String> getalldata() {
        //crate a arraylist
//       ArrayList<String> namesList=new ArrayList<String >();
        //getting data of students who are completed the assignment
        String selectQuery = "SELECT COLUMN_NAME, COLUMN_ASSIGNMENTTASK FROM TABLE_NAME where COLUMN_ASSIGNMENTTASK='Completed'";
        //select all query
        SQLiteDatabase db = getWritableDatabase();
       // long count = DatabaseUtils.queryNumEntries(db,"");
        Cursor cursor = db.rawQuery(selectQuery, null);

        //add alldata in a arraylist
        if (cursor.moveToFirst()) {
            do {
                String names = cursor.getString(cursor.getColumnIndex("COLUMN_NAME"));
                //adding
                namesList.add(names);
            } while (cursor.moveToNext());

        }

        // Toast.makeText(context,namesList.toString(),Toast.LENGTH_LONG).show();
        return namesList;
    }

    public ArrayList<String> getalldatas() {
        //crate a arraylist
//       ArrayList<String> namesList=new ArrayList<String >();
        //getting data of students who are Notcompleted the assignment
        String selectQuery = "SELECT COLUMN_NAME, COLUMN_ASSIGNMENTTASK FROM TABLE_NAME where COLUMN_ASSIGNMENTTASK='NotCompleted'";
        //select all query
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        //add alldata in a arraylist
        if (cursor.moveToFirst()) {
            do {
                String names = cursor.getString(cursor.getColumnIndex("COLUMN_NAME"));
                //adding
                namesList.add(names);
            } while (cursor.moveToNext());

        }
        // Toast.makeText(context, cursor.toString(), Toast.LENGTH_SHORT).show();
        // Toast.makeText(context,namesList.toString(),Toast.LENGTH_LONG).show();
        return namesList;
    }

    public void deletealldata() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + "TABLE_NAME");
    }

    public ArrayList<String> searchByInputText(String inputText) {
        SQLiteDatabase db = getWritableDatabase();
        //String query ="SELECT COLUMN_NAME FROM TABLE_NAME where COLUMN_NAME='"+inputText+"'";

        String query = "Select COLUMN_NAME from TABLE_NAME Where(COLUMN_NAME like " + "'%" + inputText + "%'" + ")";
        Cursor cursor = db.rawQuery(query, null);
        //Toast.makeText(context, query, Toast.LENGTH_SHORT).show();
        cursor.moveToFirst();

        // if (cursor != null) {
        do {
            for (int i = 0; i < cursor.getColumnCount(); i++) {

                // Log.e("", "" + cursor.getString(i));
                // Toast.makeText(context, cursor.getString(i), Toast.LENGTH_SHORT).show();
                String names = null;
                try {
                    names = cursor.getString(i);
//adding
                namesList.add(names);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        } while (cursor.moveToNext());

        // }

        return namesList;
    }

}



