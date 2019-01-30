package com.company;

public class Time
{
    private int hour;
    private int minute;
    private int alarmHour;
    private int alarmMinute;
    private boolean alarmOn = false;
    private TimeZone timeZone;

    public Time(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }

    public Time(int hour, int minute, boolean pm)
    {
        if (!pm)
        {
            this.hour = hour;
            this.minute = minute;
        }
        else if (pm)
        {
            this.hour = hour + 12;
            this.minute = minute;
        }
    }

    public void printTime()
    {

        System.out.println(this.hour + ":" + this.minute);
    }

    public String getMilitaryTime()
    {

        int minuteCount = String.valueOf(this.minute).length();
        String militaryTime;

        int adjustedHour;

        switch (timeZone)
        {
            case EST:
                adjustedHour = this.hour - 5;
                break;
            case CST:
                adjustedHour = this.hour - 6;
                break;
            case MST:
                adjustedHour = this.hour - 7;
                break;
            case PST:
                adjustedHour = this.hour - 8;
                break;
            default:
                adjustedHour = this.hour;
        }

        if (minuteCount < 2)
        {
            militaryTime = adjustedHour + ":0" + this.minute;
        }
        else
        {
            militaryTime = adjustedHour + ":" + this.minute;
        }
        return militaryTime;
    }

    public String getTime()
    {
        String time;
        int minuteCount = String.valueOf(this.minute).length();
        int adjustedHour;

        switch (timeZone)
        {
            case EST:
                adjustedHour = this.hour - 5;
                break;
            case CST:
                adjustedHour = this.hour - 6;
                break;
            case MST:
                adjustedHour = this.hour - 7;
                break;
            case PST:
                adjustedHour = this.hour - 8;
                break;
            default:
                adjustedHour = this.hour;
        }

        int afternoon = adjustedHour - 12;

        if (adjustedHour == 0)
        {
            adjustedHour = adjustedHour + 12;
        }
        if (adjustedHour <= 12 && minuteCount < 2)
        {
            time = adjustedHour + ":0" + this.minute + " AM";
        }
        else if (adjustedHour > 12 && minuteCount < 2)
        {
            time = afternoon + ":0" + this.minute + " PM";
        }
        else if (adjustedHour <= 12)
        {
            time = adjustedHour + ":" + this.minute + " AM";
        }
        else
        {
            time = afternoon + ":" + this.minute + " PM";
        }
        return time;
    }

    public void incrementHour()
    {
        int nextHour = this.hour + 1;
        if (nextHour == 25)
        {
            this.hour = 0;
        }
        else
        {
            ++this.hour;
        }

    }

    public void decrementHour()
    {
        int nextHour = this.hour - 1;
        if (nextHour == -1)
        {
            this.hour = 23;
        }
        else
        {
            --this.hour;
        }

    }

    public void incrementMinute()
    {
        int nextMinute = this.minute + 1;
        if (nextMinute == 60)
        {
            this.minute = 0;
            ++this.hour;
        }
        else
        {
            ++this.minute;
        }
    }

    public void decrementMinute()
    {
        int nextMinute = this.minute - 1;
        if (nextMinute == 0)
        {
            --this.minute;
            --this.hour;
        }
        else
        {
            --this.minute;
        }
    }

    public void setAlarmTime(int hour, int minute)
    {
        this.alarmHour = hour;
        this.alarmMinute = minute;
    }

    public void buzz()
    {
        if (this.hour == this.alarmHour && this.minute == this.alarmMinute)
        {
            System.out.println("BUZZ");
        }
    }

    public void turnAlarmOn()
    {
        this.alarmOn = true;
    }

    public void turnAlarmOff()
    {
        this.alarmOn = false;
    }

    public int getMinutesApart(Time time)
    {
        int thisTotalMinutes = (this.hour * 60) + this.minute;
        int timeTotalMinutes = (time.hour * 60) + time.minute;
        int minutesApart = thisTotalMinutes - timeTotalMinutes;
        return minutesApart;
    }

    public TimeZone getTimeZone()
    {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone)
    {
        switch (timeZone)
        {
            case GMT:
                this.timeZone = timeZone;
                break;
            case CST:
                this.timeZone = timeZone;
                break;
            case EST:
                this.timeZone = timeZone;
                break;
            case MST:
                this.timeZone = timeZone;
                break;
            case PST:
                this.timeZone = timeZone;
                break;
            default:
                this.timeZone = TimeZone.GMT;
        }
    }
}
