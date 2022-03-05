package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String name = "6300JobCompare.db";
    public static final int DB_VERSION = 1;

    public static final String CREATE_JOB = "create table Jobs( _id INTEGER PRIMARY KEY AUTOINCREMENT, title varchar(64), company varchar(64), location varchar(20), livingCost integer, salary integer, bonus integer, retirementBenefits integer, relocation integer, stock integer, isCurrent boolean)";
    public static final String CREATE_WEIGHT = "create table Weight( _id INTEGER PRIMARY KEY AUTOINCREMENT, AYS integer, AYB integer, RS integer, RPB integer, RSUA integer)";

    public MyDBHelper(Context context) {
        super(context, name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_JOB);
        db.execSQL(CREATE_WEIGHT);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
