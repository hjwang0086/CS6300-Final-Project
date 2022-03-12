package edu.gatech.seclass.jobcompare6300;

public class Weight {
    private int mAYS;
    private int mAYB;
    private int mRS;
    private int mRPB;
    private int mRSUA;

    public Weight() {
        reset();
    }

    public void reset() {
        mAYS = 1;
        mAYB = 1;
        mRS = 1;
        mRPB = 1;
        mRSUA = 1;
    }

    public int getAYS() { return mAYS; }
    public int getAYB() { return mAYB; }
    public int getRS() { return mRS; }
    public int getRPB() { return mRPB; }
    public int getRSUA() { return mRSUA; }
    public int getSum() { return mAYS + mAYB + mRS + mRPB + mRSUA; }

    public void setAYS(int ays) { mAYS = ays; }
    public void setAYB(int ayb) { mAYB = ayb; }
    public void setRS(int rs) { mRS = rs; }
    public void setRPB(int rpb) { mRPB = rpb; }
    public void setRSUA(int rsua) { mRSUA = rsua; }
}
