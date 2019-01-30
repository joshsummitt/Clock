package com.company;

public class Main
{

    public static void main(String[] args)
    {
        Time timeA   = new Time(9, 03);
        Time timeB   = new Time(9, 45);
        Time timeC   = new Time(14, 07);
        Time timeD   = new Time(14, 30);

        Time timeA1   = new Time(5, 07, false);
        Time timeB1  = new Time(9, 45, false);
        Time timeC1  = new Time(2, 07, true);
        Time timeD1   = new Time(2, 30, true);

        timeA.setAlarmTime(9, 7);
        timeA.turnAlarmOn();

        System.out.println("Minutes apart: " + timeA.getMinutesApart(timeB));
        timeA.setTimeZone(TimeZone.GMT);
        System.out.println(timeA.getTime());
        System.out.println(timeA.getMilitaryTime());
        timeA.setTimeZone(TimeZone.EST);
        System.out.println(timeA.getTime());
        System.out.println(timeA.getMilitaryTime());
        timeA.setTimeZone(TimeZone.CST);
        System.out.println(timeA.getTime());
        System.out.println(timeA.getMilitaryTime());

    }
}
