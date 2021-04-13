package com.lemur.profrate;

import android.os.Parcel;
import android.os.Parcelable;

public class Ratings implements Parcelable {

    private String className;
    private int classNum;
    private String classPrefix;
    private int deadlines;
    private String description;
    private int etr;
    private int fair;
    private int group;
    private int hw;
    private boolean online;
    private int pap;
    private int pres;
    private String  profFirst;
    private String profLast;
    private int rating;
    private int read;
    private boolean repeat;
    private String semester;
    private int year;


    public Ratings() {
    }

    public Ratings(String className, int classNum, String classPrefix, int deadlines, String description, int etr, int fair, int group, int hw, boolean online, int pap, int pres, String profFirst, String profLast, int rating, int read, boolean repeat, String semester, int year) {
        this.className = className;
        this.classNum = classNum;
        this.classPrefix = classPrefix;
        this.deadlines = deadlines;
        this.description = description;
        this.etr = etr;
        this.fair = fair;
        this.group = group;
        this.hw = hw;
        this.online = online;
        this.pap = pap;
        this.pres = pres;
        this.profFirst = profFirst;
        this.profLast = profLast;
        this.rating = rating;
        this.read = read;
        this.repeat = repeat;
        this.semester = semester;
        this.year = year;
    }

    protected Ratings(Parcel in) {
        className = in.readString();
        classNum = in.readInt();
        classPrefix = in.readString();
        deadlines = in.readInt();
        description = in.readString();
        etr = in.readInt();
        fair = in.readInt();
        group = in.readInt();
        hw = in.readInt();
        online = in.readByte() != 0;
        pap = in.readInt();
        pres = in.readInt();
        profFirst = in.readString();
        profLast = in.readString();
        rating = in.readInt();
        read = in.readInt();
        repeat = in.readByte() != 0;
        semester = in.readString();
        year = in.readInt();
    }

    public static final Creator<Ratings> CREATOR = new Creator<Ratings>() {
        @Override
        public Ratings createFromParcel(Parcel in) {
            return new Ratings(in);
        }

        @Override
        public Ratings[] newArray(int size) {
            return new Ratings[size];
        }
    };

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getClassPrefix() {
        return classPrefix;
    }

    public void setClassPrefix(String classPrefix) {
        this.classPrefix = classPrefix;
    }

    public int getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(int deadlines) {
        this.deadlines = deadlines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEtr() {
        return etr;
    }

    public void setEtr(int etr) {
        this.etr = etr;
    }

    public int getFair() {
        return fair;
    }

    public void setFair(int fair) {
        this.fair = fair;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getHw() {
        return hw;
    }

    public void setHw(int hw) {
        this.hw = hw;
    }

    public boolean getOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getPap() {
        return pap;
    }

    public void setPap(int pap) {
        this.pap = pap;
    }

    public int getPres() {
        return pres;
    }

    public void setPres(int pres) {
        this.pres = pres;
    }

    public String getProfFirst() {
        return profFirst;
    }

    public void setProfFirst(String profFirst) {
        this.profFirst = profFirst;
    }

    public String getProfLast() {
        return profLast;
    }

    public void setProfLast(String profLast) {
        this.profLast = profLast;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public boolean getRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(className);
        dest.writeInt(classNum);
        dest.writeString(classPrefix);
        dest.writeInt(deadlines);
        dest.writeString(description);
        dest.writeInt(etr);
        dest.writeInt(fair);
        dest.writeInt(group);
        dest.writeInt(hw);
        dest.writeByte((byte) (online ? 1 : 0));
        dest.writeInt(pap);
        dest.writeInt(pres);
        dest.writeString(profFirst);
        dest.writeString(profLast);
        dest.writeInt(rating);
        dest.writeInt(read);
        dest.writeByte((byte) (repeat ? 1 : 0));
        dest.writeString(semester);
        dest.writeInt(year);
    }
}
