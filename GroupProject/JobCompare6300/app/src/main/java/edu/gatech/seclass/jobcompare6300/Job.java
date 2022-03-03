package edu.gatech.seclass.jobcompare6300;

public class Job {
    private String mTitle;
    private String mCompany;
    private String mLocation;
    private int mLivingCost;
    private int mSalary;
    private int mBonus;
    private int mRetirementBenefits;
    private int mRelocation;
    private int mStock;

    public Job() { reset(); }

    public void reset() {
        mTitle = "";
        mCompany = "";
        mLocation = "";
        mLivingCost = 0;
        mSalary = 0;
        mBonus = 0;
        mRetirementBenefits = 0;
        mRelocation = 0;
        mStock = 0;
    }

    public String getTitle() { return mTitle; }
    public String getCompany() { return mCompany; }
    public String getLocation() { return mLocation; }
    public int getLivingCost() { return mLivingCost; }
    public int getSalary() { return mSalary; }
    public int getBonus() { return mBonus; }
    public int getRetirementBenefits() { return mRetirementBenefits; }
    public int getRelocation() { return mRelocation; }
    public int getStock() { return mStock; }

    public void setTitle(String title) { mTitle = title; }
    public void setCompany(String company) { mCompany = company; }
    public void setLocation(String location) { mLocation = location; }
    public void setLivingCost(int livingCost) { mLivingCost = livingCost; }
    public void setSalary(int salary) { mSalary = salary; }
    public void setBonus(int bonus) { mBonus = bonus; }
    public void setRetirementBenefits(int retirementBenefits) { mRetirementBenefits = retirementBenefits; }
    public void setRelocation(int relocation) { mRelocation = relocation; }
    public void setStock(int stock) { mStock = stock; }
}
