package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class JobDao {
    private Context context;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;

    public JobDao(Context context) {
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

    public long addJobs(Job job) {

        ContentValues values = new ContentValues();

        values.put("title", job.getTitle());
        values.put("company", job.getCompany());
        values.put("location", job.getLocation());
        values.put("livingCost", job.getLivingCost());
        values.put("salary", job.getSalary());
        values.put("bonus", job.getBonus());
        values.put("retirementBenefits", job.getRetirementBenefits());
        values.put("relocation", job.getRelocation());
        values.put("stock", job.getStock());
        values.put("isCurrent", job.isCurrentJob());

        return db.insert("Jobs", null, values);
    }

    public int updateJob(Job job) {

        ContentValues values = new ContentValues();

        values.put("title", job.getTitle());
        values.put("company", job.getCompany());
        values.put("location", job.getLocation());
        values.put("livingCost", job.getLivingCost());
        values.put("salary", job.getSalary());
        values.put("bonus", job.getBonus());
        values.put("retirementBenefits", job.getRetirementBenefits());
        values.put("relocation", job.getRelocation());
        values.put("stock", job.getStock());
        values.put("isCurrent", job.isCurrentJob());

        return db.update("Jobs", values, "isCurrent=?", new String[]{String.valueOf("True")});
    }

    public List<Job> getData(){
        List listJob = new ArrayList();
        Cursor cursor = db.query("Jobs", null, null, null, null, null,null);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            if(cursor != null && cursor.getCount()>=1) {
                Job current = new Job();
                current.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                current.setCompany(cursor.getString(cursor.getColumnIndex("company")));
                current.setLocation(cursor.getString(cursor.getColumnIndex("location")));
                current.setLivingCost(cursor.getInt(cursor.getColumnIndex("livingCost")));
                current.setSalary(cursor.getInt(cursor.getColumnIndex("salary")));
                current.setBonus(cursor.getInt(cursor.getColumnIndex("bonus")));
                current.setRetirementBenefits(cursor.getInt(cursor.getColumnIndex("retireBenefit")));
                current.setRelocation(cursor.getInt(cursor.getColumnIndex("relocation")));
                current.setStock(cursor.getInt(cursor.getColumnIndex("stock")));
                current.setCurrentJob(cursor.getInt(cursor.getColumnIndex("isCurrent")) > 0);
                listJob.add(current);
            }
        }

        return listJob;
    }
}
