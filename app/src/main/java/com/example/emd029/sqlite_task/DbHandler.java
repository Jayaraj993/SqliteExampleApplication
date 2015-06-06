package com.example.emd029.sqlite_task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by EMD029 on 6/1/2015.
 */
public class DbHandler extends SQLiteOpenHelper  {
    ArrayList<String> namesList=new ArrayList<String >();
    //table,database names
    static final String DATABASE_NAME="StudentDB";
     static final String TABLE_NAME="Sqllite Task";
     static final int DATABASE_VERSION=1;
    //column names
     static final String COLUMN_ID="id";
     static final String COLUMN_NAME="name";
     static final String COLUMN_SUBJECT="subject";
     static final String COLUMN_ASSIGNMENTTASK="assignmenttask";
     Context context;
    public DbHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
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
        sqLiteDatabase.execSQL("Drop Table If Exists"+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addName(StudentNames names){
        SQLiteDatabase db=this.getWritableDatabase();
        if(db.isOpen()){
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
    //the below hided method is used to get all column data that is datas of table
   /* public List<StudentNames> getalldata(){
        //crate a arraylist
        List<StudentNames> namesList=new ArrayList<StudentNames>();
        String selectQuery="SELECT  * FROM " + "TABLE_NAME";
        //select all query
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery(selectQuery,null);

        //add alldata in a arraylist
        if (cursor.moveToFirst()) {
            do {
                StudentNames names=new StudentNames();
                names.setId(Integer.parseInt(cursor.getString(0)));
                names.setName(cursor.getString(1));
                names.setSubject(cursor.getString(2));
                names.setAssignmentTask(cursor.getString(3));
                //adding
                namesList.add(names);
            }while (cursor.moveToNext());

        }
        Toast.makeText(context,namesList.toString(),Toast.LENGTH_LONG).show();
        return namesList;

    }*/
   public ArrayList<String> getalldata(){
       //crate a arraylist
//       ArrayList<String> namesList=new ArrayList<String >();
       //getting data of students who are completed the assignment
       String selectQuery="SELECT COLUMN_NAME, COLUMN_ASSIGNMENTTASK FROM TABLE_NAME where COLUMN_ASSIGNMENTTASK='Completed'";
       //select all query
       SQLiteDatabase db=this.getWritableDatabase();

       Cursor cursor=db.rawQuery(selectQuery,null);

       //add alldata in a arraylist
       if (cursor.moveToFirst()) {
           do {
               String names=cursor.getString(cursor.getColumnIndex("COLUMN_NAME"));
               //adding
              namesList.add(names);
           }while (cursor.moveToNext());

       }
      // Toast.makeText(context,namesList.toString(),Toast.LENGTH_LONG).show();
       return namesList;
   }

    public ArrayList<String> getalldatas(){
        //crate a arraylist
//       ArrayList<String> namesList=new ArrayList<String >();
        //getting data of students who are Notcompleted the assignment
        String selectQuery="SELECT COLUMN_NAME, COLUMN_ASSIGNMENTTASK FROM TABLE_NAME where COLUMN_ASSIGNMENTTASK='NotCompleted'";
        //select all query
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery(selectQuery,null);

        //add alldata in a arraylist
        if (cursor.moveToFirst()) {
            do {
                String names=cursor.getString(cursor.getColumnIndex("COLUMN_NAME"));
                //adding
                namesList.add(names);
            }while (cursor.moveToNext());

        }
        // Toast.makeText(context,namesList.toString(),Toast.LENGTH_LONG).show();
        return namesList;

    }

}
