/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csci360.answeringMachine;

/**
 *
 * messageTime: Time
 * callerNum: int
 * messageDuration: int
 * messageContent: String
 *
 * +assignTime()
 * +recordDuration()
 * +saveMessage()
 * +playMessage()
 *
 * Created by David Schirduan
 * with assistance from Goup UML
 * Message class
 */
public class Message {

    int callerNum;
    String messContent; //testing purposes
    Time messTime;

    public Message()
    {
        this.messTime = new Time();
        this.callerNum = 8675309;
        this.messContent = "hello, this is Jacks colon speaking";
    }

    public Message(int cN, String mC)
    {
        this.messTime = new Time();
        this.callerNum = cN;
        this.messContent = mC;
    }

    @Override
    public String toString()
    {
        String fin = "";

        fin = this.messContent + "\n" + "recorded at " + this.messTime;

        return fin;

    }


}
