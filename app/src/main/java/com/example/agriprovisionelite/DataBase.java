package com.example.agriprovisionelite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.example.agriprovisionelite.Models.BlogDBModel;
import com.example.agriprovisionelite.Models.govSchemeModel;

import java.io.ByteArrayOutputStream;

public class DataBase  extends SQLiteOpenHelper {

    private ByteArrayOutputStream byteArrayOutputStream;
    private ByteArrayOutputStream byteArrayOutputStream2;

    private  byte[] imageInByte;
    private  byte[] imageInByte2;

    public DataBase(@Nullable Context context) {
        super(context,"AgriProVisionEliteDB.db",null,1);    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table  " +"farmerDetails"  + " (f_id INTEGER PRIMARY KEY AUTOINCREMENT,fName TEXT,fEmail TEXT,fPassword TEXT,fMobile TEXT,fAdhar TEXT,fState TEXT,fDist TEXT,fTal TEXT ) ");
        db.execSQL(" create table  " +"krishiOfficerDetails"  + " (k_id INTEGER PRIMARY KEY AUTOINCREMENT,kName TEXT,kEmail TEXT,kPassword TEXT,kMobile TEXT,specialcode TEXT,kState TEXT,kDist TEXT,kTal TEXT ) ");
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
                "name TEXT," +
                " Ratings TEXT," +
                " Suggetions TEXT "+")");




        db.execSQL("CREATE TABLE Blog (" +
                "b_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "k_id INTEGER," +
                "title TEXT," +
                "author Text," +
                "description Text," +
                "b_image BLOB," +
                "FOREIGN KEY (k_id) REFERENCES krishiOfficerDetails(k_id)" +
                ")");






        db.execSQL("CREATE TABLE Gov_Scheme (" +
                "gov_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "k_id INTEGER," +
                "Title TEXT," +
                "Description Text," +
                "Documents Text," +
                "Date Text," +
                "image BLOB," +
                "FOREIGN KEY (k_id) REFERENCES krishiOfficerDetails(k_id)" +
                ")");

//      ------------------------------------------  Sushant


           String createCropTable = "Create Table Crop(c_id INTEGER PRIMARY KEY AUTOINCREMENT " + ",c_name TEXT " + ",c_sowing_date TEXT"  + ",c_duration TEXT " + ",c_area TEXT)";
           String CreateExpensesTable = "CREATE TABLE Expenses (" +
                "expense_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "c_id INTEGER," +
                "activity TEXT," +
                "amount TEXT," +
                "e_date TEXT," +
                "FOREIGN KEY (c_id) REFERENCES Crop(c_id)" +
                ")" ;



        db.execSQL(createCropTable);
        db.execSQL(CreateExpensesTable);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists farmerDetails");
        db.execSQL("drop table if exists krishiOfficerDetails");
        db.execSQL("drop table if exists Gov_Scheme");
        db.execSQL("drop table if exists Labors");
        db.execSQL("drop table if exists LaborsAttendance");
        db.execSQL("drop table if exists Feedback");
        db.execSQL("drop table if exists Blog");
        db.execSQL("drop table if exists Crop");
        db.execSQL("drop table if exists Expenses");



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
        Cursor c=db.rawQuery("select * from krishiOfficerDetails ",null);

        return c;
    }








    //-------------------------------------------- for Admin side-------------------------------------------------------------------------------------------------














/////------------------for gov scheme--------------------------
//    public  boolean storeData(ModalClass modalClass,String date){
//
//        SQLiteDatabase db =this.getWritableDatabase();
//        Bitmap imageToStoreBitmap=modalClass.getProfileImage();
//        byteArrayOutputStream=new ByteArrayOutputStream();
//        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//        imageInByte=byteArrayOutputStream.toByteArray();
//        ContentValues contentValues=new ContentValues();
//
//        contentValues.put("Title",modalClass.getTitle());
//        contentValues.put("Description",modalClass.getDescription());
//        contentValues.put("Eligibility",modalClass.getEligibility());
//        contentValues.put("Documents",modalClass.getDocuments());
//        contentValues.put("Date",date);
//        contentValues.put("image",imageInByte);
//
//        long checkIfQueryRun=db.insert("Gov_Scheme",null,contentValues);
//        return checkIfQueryRun != -1;
//
//
//
//    }
//
//    public Cursor getGovDetails(){
//       SQLiteDatabase db=this.getReadableDatabase();
//       Cursor cursor=db.rawQuery("select * from Gov_Scheme",null);
//return cursor;
//
//    }






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


//        db.execSQL("CREATE TABLE Feedback (" +
//                "feedback_id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "f_id INTEGER," +
//                "name TEXT," +
//                " Ratings TEXT," +
//                " Suggetions TEXT," +
//                "FOREIGN KEY (f_id) REFERENCES farmerDetails(f_id)" +
//                ")");





    public  boolean insertFarmerfeedback(String name,String ratting,String Suggetions){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("name",name);
        cv.put("Ratings",ratting);

        cv.put("Suggetions",Suggetions);
        long res=db.insert("Feedback",null,cv);
        return res != -1;
    }






//-------------------------------------------blog-------------------------------------


    public boolean storedBlogData(BlogDBModel blogDBModel){

        Bitmap imageToStored =blogDBModel.getImage();
        ByteArrayOutputStream  byteArrayOutputStream=new ByteArrayOutputStream();
        imageToStored.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imageInByte=byteArrayOutputStream.toByteArray();



        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("title",blogDBModel.getTilte());
        cv.put("author",blogDBModel.getAuthor());
        cv.put("description",blogDBModel.getDescription());
        cv.put("b_image",imageInByte);

        long res=db.insert("Blog",null,cv);
        return res != -1;



    }


    public Cursor getBlogDetails(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Blog",null);
        return cursor;

    }



//--------------------------scheme--------------------------


    public boolean storedGovData(govSchemeModel model,String date){

        Bitmap imageToStored =model.getgImage();
        ByteArrayOutputStream  byteArrayOutputStream2=new ByteArrayOutputStream();
        imageToStored.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream2);
        imageInByte2=byteArrayOutputStream2.toByteArray();








        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("Title",model.getTitle());
        cv.put("Description",model.getDescription());
        cv.put("Documents",model.getDocuments());

        cv.put("Date",date);

        cv.put("image",imageInByte2);

        long res=db.insert("Gov_Scheme",null,cv);
        return res != -1;



    }


    public Cursor getGovDetails(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Gov_Scheme",null);
        return cursor;

    }


    public Cursor getAllEmails() {
        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("SELECT " + COLUMN_MAIL_ID + " FROM " + TABLE_FARMER, null);
        return db.rawQuery("SELECT fEmail FROM farmerDetails", null);

    }



//------------------  -------------------------   Sushant--------------------------------------------

public boolean addcrop(String c_name, String c_sowing_date, String c_duration, String c_area ){
    SQLiteDatabase db =this.getWritableDatabase();
    ContentValues cv =new ContentValues();
    cv.put("c_name",c_name);
    cv.put("c_sowing_date",c_sowing_date);
    cv.put("c_duration",c_duration);
    cv.put("c_area",c_area);

    long res=db.insert("Crop",null,cv);
    return res != -1;



}



    public void deleteCrop(String cropId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Crop", "c_id=?", new String[]{cropId});
        db.close();
    }


    public boolean addExpense(String c_id, String activity, String amount, String e_date ){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("c_id",c_id);
        cv.put("activity",activity);
        cv.put("amount",amount);
        cv.put("e_date",e_date);

        long res=db.insert("Expenses",null,cv);
        return res != -1;



    }


    public Cursor getCrop(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Crop ORDER BY c_id DESC",null);
        return cursor;

    }

    public Cursor getExpenses(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Expenses",null);
        return  cursor;
    }

    public Cursor getExpenses_crop(String c_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = { c_id };
        Cursor cursor = db.rawQuery("SELECT * FROM Expenses WHERE c_id = ?", selectionArgs);
        return cursor;
    }




}
