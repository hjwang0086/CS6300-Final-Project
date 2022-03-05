package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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

        return db.update("Jons", values, "isCurrent=?", new String[]{String.valueOf("True")});
    }

    public ArrayList<String> getData(){
        ArrayList listOffer = new ArrayList();
        String[] columns = {"title", "company","score","isCurrent"};
        Cursor cursor = db.query("Jobs", columns, null, null, null, null,"score"+"DESC");

        int titleCol = cursor.getColumnIndex("title");
        int companyCol = cursor.getColumnIndex("company");
        int scoreCol = cursor.getColumnIndex("score");
        int isCurrentCol = cursor.getColumnIndex("isCurrent");

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            if(cursor.getString(isCurrentCol) == "Ture"){
                listOffer.add(cursor.getString(titleCol) + "  " + cursor.getString(companyCol) + "  " + cursor.getString(scoreCol) + "<<---");
            }else{
                listOffer.add(cursor.getString(titleCol) + "  " + cursor.getString(companyCol) + "  " + cursor.getString(scoreCol));

            }
        }

        return listOffer;
    }
}
