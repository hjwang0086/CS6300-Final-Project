package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class WeightDao {
    private Context context;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;

    public WeightDao(Context context) {
        this.context = context;
    }

    public void open(){
        dbHelper = new MyDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    public long addWeight(Weight weight) {
        Cursor cursor = db.query("Weight", null, null, null, null, null,null);
        ContentValues values = new ContentValues();
        if (cursor != null && cursor.getCount() == 0) {
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

    public Weight getWeight() {
        Weight weight = new Weight();
        Cursor cursor = db.query("Weight", null, null, null, null, null,null);
        cursor.moveToFirst();
        if (cursor != null && cursor.getCount() >= 1) {
            weight.setAYS(cursor.getInt(cursor.getColumnIndex("AYS")));
            weight.setAYB(cursor.getInt(cursor.getColumnIndex("AYB")));
            weight.setRS(cursor.getInt(cursor.getColumnIndex("RS")));
            weight.setRPB(cursor.getInt(cursor.getColumnIndex("RPB")));
            weight.setRSUA(cursor.getInt(cursor.getColumnIndex("RSUA")));
        } else {
            weight = null;
        }
        return weight;
    }
}
