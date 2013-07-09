/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csci360.answeringMachine;
import java.util.*;
/**
 * hour: int
 * min: int
 * sec: int
 *
 * Created by David Schirduan
 * with assistance from Goup UML
 * Time class
 */
public class Time {

    int hour;
    int min;
    int sec;
    Calendar cal;


    public Time()
    {
        cal = Calendar.getInstance();
        hour = cal.HOUR_OF_DAY;
        min = cal.MINUTE;
        sec = cal.SECOND;
    }


    @Override
    public String toString()
    {
        String fin = "";

        fin = this.hour + ":" + this.min + ":" + this.sec;

        return fin;

    }

}
