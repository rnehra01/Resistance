package com.example.pardeep.resistance;

import com.example.pardeep.resistance.TableData.TableInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.util.Log;

public class Warrior_db extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;



    public Warrior_db(Context context) {
        super(context, TableInfo.DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TableInfo.TABLE_WARRIORS+ "("+ TableInfo.WARRIOR_NAME + " TEXT, "+TableInfo.WARRIOR_ALLIANCE+" TEXT, "
                +TableInfo.WARRIOR_SPECIES+" TEXT, "+TableInfo.WARRIOR_PLANET+" TEXT, "+TableInfo.WARRIOR_DATE+" TEXT, "
                +TableInfo.WARRIOR_GENDER+" TEXT); ";
        db.execSQL(query);
        Log.d("Database operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addWarrior(Warrior_db dop,String name,String alliance,String species,String planet,String date,String gender){
        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.WARRIOR_NAME, name);
        cv.put(TableInfo.WARRIOR_ALLIANCE,alliance);
        cv.put(TableInfo.WARRIOR_SPECIES,species);
        cv.put(TableInfo.WARRIOR_PLANET,planet);
        cv.put(TableInfo.WARRIOR_DATE,date);
        cv.put(TableInfo.WARRIOR_GENDER,gender);
        long k=SQ.insert(TableInfo.TABLE_WARRIORS, null, cv);
        Log.d("Database operations","one Row inserted");
    }


    public Cursor getInformation (Warrior_db dop){
        SQLiteDatabase SQ=dop.getReadableDatabase();
        String [] columns={TableInfo.WARRIOR_NAME,TableInfo.WARRIOR_ALLIANCE,TableInfo.WARRIOR_SPECIES,TableInfo.WARRIOR_PLANET,TableInfo.WARRIOR_DATE,TableInfo.WARRIOR_GENDER};
        Cursor CR=SQ.query(TableInfo.TABLE_WARRIORS, columns, null, null, null, null, null);
        return CR;

    }



}
