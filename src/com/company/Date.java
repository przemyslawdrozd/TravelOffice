package com.company;

import java.util.StringTokenizer;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Date of(String date){

        StringTokenizer parser = new StringTokenizer(date);
        int[] myDate = new int[3];
        int counter = 0;
        while (parser.hasMoreTokens()){
            String token = parser.nextToken("-");
            myDate[counter++] = Integer.parseInt(token);
        }

        return new Date(myDate[0], myDate[1], myDate[2]);
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

    public void getMoreInfo() {
        System.out.println(year + "/" + month + "/" + day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
