package edu.ucsb.cs156.student;

/** 
 * Represents a time of day as the minutes since midnight.
 * 0 is midnight.
 * 10 is 12:10am
 * 70 is 01:10am
 * 480 is 08:00am
 * 4801 is 08:01am
 */
public class Time {
     private int m; // minutes since midnight

     public Time(int hours, int min) {
         this.m = hours * 60 + min;
     }

     public int getHours() {
        return m / 60;
     }

     public int getMinutes() {
         return m % 60;
    }

     @Override
     public String toString() {
        if (m <  12*60) // before noon
          return String.format("%02d:%02dam",getHours(), getMinutes());
        else if (m < 13*60) // before noon
          return String.format("%02d:%02dpm",getHours(), getMinutes());
        else // before noon
          return String.format("%02d:%02dpm",getHours()-12, getMinutes());
     }
}
