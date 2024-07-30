package com.example.agriprovisionelite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DataBase  extends SQLiteOpenHelper {

    private ByteArrayOutputStream byteArrayOutputStream;
    private  byte[] imageInByte;
    public DataBase(@Nullable Context context) {
        super(context,"AgriProVisionEliteDB.db",null,1);    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table  " +"farmerDetails"  + " (f_id INTEGER PRIMARY KEY AUTOINCREMENT,fName TEXT,fEmail TEXT,fPassword TEXT,fMobile TEXT,fAdhar TEXT,fState TEXT,fDist TEXT,fTal TEXT ) ");
        db.execSQL(" create table  " +"krishiOfficerDetails"  + " (k_id INTEGER PRIMARY KEY AUTOINCREMENT,kName TEXT,kEmail TEXT,kPassword TEXT,kMobile TEXT,specialcode TEXT,kState TEXT,kDist TEXT,kTal TEXT ) ");
        db.execSQL(" create table  " +"Gov_Scheme"  + " (gov_id INTEGER PRIMARY KEY AUTOINCREMENT,Title TEXT,Description TEXT,Eligibility TEXT,Documents TEXT,Date TEXT,image BLOB ) ");
        db.execSQL(" create table  " +"Labors"  + " (l_id INTEGER PRIMARY KEY AUTOINCREMENT,first_Name TEXT,last_name TEXT,fMobile TEXT,salary TEXT,joining_date TEXT ) ");
     //   db.execSQL(" create table  " +"LaborsAttendance"  + " (la_id INTEGER PRIMARY KEY AUTOINCREMENT,Date TEXT,Attendance_status BOOLEAN, FOREIGN KEY (l_id) REFERENCES Labors(l_id) ) ");

        db.execSQL("CREATE TABLE LaborsAttendance (" +
                "la_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "l_id INTEGER," +
                "Date TEXT," +
                "Attendance_status BOOLEAN," +
                "FOREIGN KEY (l_id) REFERENCES Labors(l_id)" +
                ")");


        db.execSQL("CREATE TABLE Feedback (" +
                "feedback_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "f_id INTEGER," +
                "name TEXT," +
                " Ratings TEXT," +
                " Suggetions TEXT," +
                "FOREIGN KEY (f_id) REFERENCES farmerDetails(f_id)" +
                ")");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists farmerDetails");
        db.execSQL("drop table if exists krishiOfficerDetails");
        db.execSQL("drop table if exists Gov_Scheme");
        db.execSQL("drop table if exists Labors");
        db.execSQL("drop table if exists LaborsAttendance");
        db.execSQL("drop table if exists Feedback");



        onCreate(db);

    }



    //-------------------------------------------- for farmer ----------------------------------------------------------------------------------------------

//    public  boolean insertFarmerData (String name ,String email, String password,String mobile,String adhar,String state, String dist ,String tal){
//        SQLiteDatabase db =this.getWritableDatabase();
//        ContentValues cv =new ContentValues();
//        cv.put("fName",name);
//        cv.put("fEmail",email);
//        cv.put("fPassword",password);
//        cv.put("fMobile",mobile);
//        cv.put("fAdhar",adhar);
//        cv.put("fState",state);
//        cv.put("fDist",dist);
//        cv.put("fTal",tal);
//
//        long res=db.insert("farmerDetails",null,cv);
//        return res != -1;
//    }



    public  boolean insertFarmerData1(farmerRegisterModel model){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("fName",model.getF_name());
        cv.put("fEmail",model.getF_email());
        cv.put("fPassword",model.getF_password());
        cv.put("fMobile",model.getF_mobile());
        cv.put("fAdhar",model.getF_adhar());
        cv.put("fState",model.getF_state());
        cv.put("fDist",model.getF_dist());
        cv.put("fTal",model.getF_tal());

        long res=db.insert("farmerDetails",null,cv);
        return res != -1;
    }




    public Cursor get_Farmer_Details(){

        SQLiteDatabase db =this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from farmerDetails ",null);
        return c;

    }

















//-------------------------------------------- for Krishi Officer ----------------------------------------------------------------------------------------------
//
//    public  boolean insertKrishiOfficerData (String kname ,String kemail, String kpassword,String kmobile,String kSpeicalCode,String kstate, String kdist ,String ktal){
//
//        SQLiteDatabase db =this.getWritableDatabase();
//        ContentValues cv =new ContentValues();
//        cv.put("kName",kname);
//        cv.put("kEmail",kemail);
//        cv.put("kPassword",kpassword);
//        cv.put("kMobile",kmobile);
//        cv.put("kSpeicalCode",kSpeicalCode);
//        cv.put("kState",kstate);
//        cv.put("kDist",kdist);
//        cv.put("kTal",ktal);
//
//        long res=db.insert("krishiOfficerDetails",null,cv);
//        return res != -1;
//
//    }





    public  boolean insertKrishiOfficerData1 (KrishiOfficerRegisterModel model){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("kName",model.getKname());
        cv.put("kEmail",model.getKemail());
        cv.put("kPassword",model.getKpassword());
        cv.put("kMobile",model.getKmobile());
        cv.put("specialcode",model.getkSpeicalCode());
        cv.put("kState",model.getKstate());
        cv.put("kDist",model.getKdist());
        cv.put("kTal",model.getKtal());

        long res=db.insert("krishiOfficerDetails",null,cv);
        return res != -1;

    }







    public Cursor get_KrishiOfficer_Details(){

        SQLiteDatabase db =this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from farmerDetails ",null);

        return c;
    }








    //-------------------------------------------- for Admin side-------------------------------------------------------------------------------------------------














///------------------for gov scheme--------------------------
    public  boolean storeData(ModalClass modalClass,String date){

        SQLiteDatabase db =this.getWritableDatabase();
        Bitmap imageToStoreBitmap=modalClass.getProfileImage();
        byteArrayOutputStream=new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imageInByte=byteArrayOutputStream.toByteArray();
        ContentValues contentValues=new ContentValues();

        contentValues.put("Title",modalClass.getTitle());
        contentValues.put("Description",modalClass.getDescription());
        contentValues.put("Eligibility",modalClass.getEligibility());
        contentValues.put("Documents",modalClass.getDocuments());
        contentValues.put("Date",date);
        contentValues.put("image",imageInByte);

        long checkIfQueryRun=db.insert("Gov_Scheme",null,contentValues);
        return checkIfQueryRun != -1;



    }

    public Cursor getGovDetails(){
       SQLiteDatabase db=this.getReadableDatabase();
       Cursor cursor=db.rawQuery("select * from Gov_Scheme",null);
return cursor;

    }






    // for attendance

    //--------------------------------------------------------------------------------
    public  boolean insertLaborData (String fname ,String lname,String mobile,String salary,String joining_date){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("first_Name",fname);
        cv.put("last_name",lname);
        cv.put("fMobile",mobile);
        cv.put("salary",salary);
        cv.put("joining_date",joining_date);
        long res=db.insert("Labors",null,cv);
        return res != -1;


    }


    public Cursor getLaborDetails(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Labors",null);
        return cursor;

    }




    //------------------------  for search labor details using id   -----------------------------



    public Cursor getLaborDetailsUsingId(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = { id };
        Cursor cursor = db.rawQuery("SELECT * FROM Labors WHERE l_id = ?", selectionArgs);
        return cursor;

    }



    //-----------------------for insert labor attendace mark ------------------------

    public  boolean insertLaborAttendaceData(String id ,String date,boolean status){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("Date",date);
        cv.put("Attendance_status",status);
        cv.put("l_id", id);
        long res=db.insert("LaborsAttendance",null,cv);
        return res != -1;
    }



    public Cursor getLaborAttendanceDetails(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = { id };
        Cursor cursor = db.rawQuery("SELECT * FROM LaborsAttendance WHERE l_id = ?", selectionArgs);
        return cursor;


    }



    //------------------------------FEEDBACK-------------------------------------------------------------


        db.execSQL("CREATE TABLE Feedback (" +
                "feedback_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "f_id INTEGER," +
                "name TEXT," +
                " Ratings TEXT," +
                " Suggetions TEXT," +
                "FOREIGN KEY (f_id) REFERENCES farmerDetails(f_id)" +
                ")");





    public  boolean insertFarmerfeedback(String id ,String name,String ratting,String Suggetions){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("name",name);
        cv.put("Ratings",ratting);
        cv.put("f_id", id);
        cv.put("Suggetions",Suggetions);
        long res=db.insert("Feedback",null,cv);
        return res != -1;
    }














}
