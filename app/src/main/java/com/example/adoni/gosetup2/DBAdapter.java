package com.example.adoni.gosetup2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {

    myDbHelper myhelper;
    public DBAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    //Student Table...

    public long insertData(String name, String username,String email ,String pass,String stream ,String subj1 ,String subj2,String subj3)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        contentValues.put(myDbHelper.MyUSERNAME,username);
        contentValues.put(myDbHelper.MyEMAIL,email);
        contentValues.put(myDbHelper.STREAM,stream);
        contentValues.put(myDbHelper.SUBJECT1,subj1);
        contentValues.put(myDbHelper.SUBJECT2,subj2);
        contentValues.put(myDbHelper.SUBJECT3,subj3);

        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.MyUSERNAME,myDbHelper.MyEMAIL,myDbHelper.MyPASSWORD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));

            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            String username =cursor.getString(cursor.getColumnIndex(myDbHelper.MyUSERNAME));



            buffer.append(cid+ "   " + username + "   " + password +"  \n");
        }
        return buffer.toString();
    }


    //Login Function
    public boolean login(String email , String pass){

        SQLiteDatabase db = myhelper.getReadableDatabase();
        // array of columns to fetch
        String[] columns = {
               myDbHelper.UID
        };
        // selection criteria
        String selection = myDbHelper.MyEMAIL + " = ?" + " AND " + myDbHelper.MyPASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {email, pass};
        // query user table with conditions
        Cursor cursor = db.query(myDbHelper.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


    //Update Student Password.....
    public int updatePassword(String email , String password)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.MyPASSWORD,password);

        int count = db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.MyEMAIL+" = ?",new String[]{email} );
        db.close();
        return count;
    }


    //Teachers Table.....


    public long addData(String name, String username,String email ,String pass,String specialization)
    {
        SQLiteDatabase dbb1 = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        contentValues.put(myDbHelper.MyUSERNAME,username);
        contentValues.put(myDbHelper.MyEMAIL,email);
        contentValues.put(myDbHelper.SPECIALIZATION,specialization);


        long id = dbb1.insert(myDbHelper.TABLE_NAME2, null , contentValues);
        return id;
    }

    public String showdata()
    {
        SQLiteDatabase db1 = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.TID,myDbHelper.NAME,myDbHelper.MyUSERNAME,myDbHelper.MyEMAIL,myDbHelper.MyPASSWORD,myDbHelper.SPECIALIZATION};
        Cursor cursor =db1.query(myDbHelper.TABLE_NAME2,columns,null,null,null,null,null);
        StringBuffer buffer1= new StringBuffer();
        while (cursor.moveToNext())
        {
            int tid =cursor.getInt(cursor.getColumnIndex(myDbHelper.TID));

            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            String username =cursor.getString(cursor.getColumnIndex(myDbHelper.MyUSERNAME));
            String  email =cursor.getString(cursor.getColumnIndex(myDbHelper.MyEMAIL));
            String specialization =cursor.getString(cursor.getColumnIndex(myDbHelper.SPECIALIZATION));

            buffer1.append(tid+ "   " + username + "   " + password +"   "+email+"   "+specialization+" \n");
        }
        return buffer1.toString();
    }
//Teacher's Login......
public boolean Teacherlogin(String email , String pass){

    SQLiteDatabase db = myhelper.getReadableDatabase();
    // array of columns to fetch
    String[] columns = {
            myDbHelper.TID
    };
    // selection criteria
    String selection = myDbHelper.MyEMAIL + " = ?" + " AND " + myDbHelper.MyPASSWORD + " = ?";
    // selection arguments
    String[] selectionArgs = {email, pass};
    // query user table with conditions
    Cursor cursor = db.query(myDbHelper.TABLE_NAME2, //Table to query
            columns,                    //columns to return
            selection,                  //columns for the WHERE clause
            selectionArgs,              //The values for the WHERE clause
            null,                       //group the rows
            null,                       //filter by row groups
            null);                      //The sort order

    int cursorCount = cursor.getCount();

    cursor.close();
    db.close();
    if (cursorCount > 0) {
        return true;
    }

    return false;
}







    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "student";   // Table1 Name
        private static final String TABLE_NAME2 = "teacher";  //Table 2 Name
        private static final int DATABASE_Version = 1;   // Database Version
        private static final String UID="_id";     // Column I (Primary Key For Student Table)
        private static final String TID = "_tid";  // Column II(Primary Key For Teacher Table)
        private static final String NAME = "Name";    //Column III
        private static final String MyUSERNAME = "UserName"; // Column IV
        private static final String MyEMAIL = "EMAIL"; // Column V
        private static final String MyPASSWORD= "Password";    // Column VI
        private static final String STREAM= "Stream";    // Column VII
        private static final String SUBJECT1= "Subject1";    // Column VIII
        private static final String SUBJECT2= "Subject2";    // Column IX
        private static final String SUBJECT3= "Subject3";    // Column X
        private static final String SPECIALIZATION= "Specialization";    // Column XI

        //Create Student Table
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+MyUSERNAME+" VARCHAR(255),"+MyEMAIL+" VARCHAR(255),"+ MyPASSWORD+" VARCHAR(255),"+ STREAM+" VARCHAR(255),"+ SUBJECT1+" VARCHAR(255),"+ SUBJECT2+" VARCHAR(255),"+ SUBJECT3+" VARCHAR(255));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;

        //Create Teacher Table
        private static final String CREATE_TABLE2 = "CREATE TABLE "+TABLE_NAME2+
                " ("+TID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+MyUSERNAME+" VARCHAR(255),"+MyEMAIL+" VARCHAR(255),"+ MyPASSWORD+" VARCHAR(255),"+SPECIALIZATION+" VARCHAR(255));";
        private static final String DROP_TABLE2 ="DROP TABLE IF EXISTS "+TABLE_NAME2;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
                db.execSQL(CREATE_TABLE2);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                db.execSQL(DROP_TABLE2);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }


        }
    }
}
