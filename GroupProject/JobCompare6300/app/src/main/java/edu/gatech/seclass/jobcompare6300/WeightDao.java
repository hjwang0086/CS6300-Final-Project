package edu.gatech.seclass.jobcompare6300.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.gatech.seclass.jobcompare6300.Entity.Job;
import edu.gatech.seclass.jobcompare6300.Entity.Weight;
import edu.gatech.seclass.jobcompare6300.MyDBHelper;

public class WeightDao {
    private Context context;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;

    public WeightDao(Context context) {
        this.context = context;
    }

    public long addJobs(Weight weight) {
        Cursor cursor = db.query("Weight", null, null, null, null, null,null);
        ContentValues values = new ContentValues();
        if (cursor != null && cursor.getCount()==0) {
            values.put("AYS", weight.getAYS());
            values.put("AYB", weight.getAYB());
            values.put("RS", weight.getRS());
            values.put("RPB", weight.getRPB());
            values.put("RSUA", weight.getRSUA());
        }
        return db.insert("Weight", null, values);
    }

    public int updateWeight(Weight weight){
        ContentValues values = new ContentValues();
        values.put("AYS", weight.getAYS());
        values.put("AYB", weight.getAYB());
        values.put("RS", weight.getRS());
        values.put("RPB", weight.getRPB());
        values.put("RSUA", weight.getRSUA());

        return db.update("Weight", values, null, null);
    }
}
