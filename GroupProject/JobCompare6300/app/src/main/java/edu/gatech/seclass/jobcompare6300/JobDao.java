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
        List<Job> listOffer = new ArrayList<Job>();
        String[] columns = {"title", "company", "location", "livingCost", "salary", "bonus", "retirementBenefits", "relocation", "stock", "isCurrent"};
        Cursor cursor = db.query("Jobs", columns, null, null, null, null,null);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Job job = new Job();
            job.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            listOffer.add(job);
        }

        return listOffer;
    }
}
