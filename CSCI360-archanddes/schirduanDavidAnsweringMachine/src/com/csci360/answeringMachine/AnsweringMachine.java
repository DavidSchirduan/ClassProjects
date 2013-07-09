/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csci360.answeringMachine;
import java.util.*;


/**
 *- numMessages: int
 *- greeting: Message
 *- clock : Clock
 *- callerNum: int
 *- phoneNum: int
 *
 * +playMessages()
 * +recordGreeting()
 * +recordMessage()
 * +playGreeting()
 * +keepMessage()
 * +deleteMessage()
 *
 * Created by David Schirduan
 * with assistance from Goup UML
 * Answering Machine class
 */
public class AnsweringMachine
{
    int callerNum;
    int phoneNum;
    int numMessages;
    Time clock;
    Message greeting;
    ArrayList messages = new ArrayList();
    String output = "";
    String messagekept = "";
    String messagedeleted = "";
    String greetingrecorded = "";
    String outputmessage = "";
    String messagerecorded = "";
    public int i = -1;
    
    public AnsweringMachine()
    {
        this.callerNum = 8675309;
        this.phoneNum = 1234567;
        this.numMessages = 7;
        this.clock = new Time();
        this.greeting = new Message(1234567, "Speak now, or forever remain unheard!");
    }

    public AnsweringMachine(int calnum, int phonum, int numess, Time cl, Message gr)
    {
        this.callerNum = calnum;
        this.phoneNum = phonum;
        this.numMessages = numess;
        this.clock = cl;
        this.greeting = gr;
    }

    public void recordMessage(Message mess)
    {
        this.i = 0;
        this.playGreeting();
        messages.add(mess);
        this.showOutput();
        messagerecorded = "message recorded";
    }

    public void playMessage(){
        {
            if (i < 0)
            {
                this.outputmessage = "you don't have any messages!";
            }
            else if(i < messages.size())
            {
                this.outputmessage = ("The next message is: " + "\n" + messages.get(i));
                this.showOutput();
                i++;
            }

            else
            {
                this.outputmessage = "you don't have any more messages";
                i = 0;
            }
        }
    }

    public void recordGreeting(String mess)
    {
        this.greeting = new Message(0000000, "hey this is Tyler Durden, please leave a message");
        greetingrecorded = "new greeting recorded";

    }

    public void playGreeting()
    {
        System.out.println(greeting);
    }

    public void keepMessage()
    {
        outputmessage = "message kept";
        this.showOutput();
    }

    public void deleteMessage()
    {
        if (i < 0)
        {
        outputmessage = "you have no messages";
        }
        else
            {
        messages.remove(i);
        outputmessage = "message deleted";
        this.showOutput();
        i--;
            }
    }

    public String showOutput()
    {
        output = "YOU HAVE " + this.messages.size() + " MESSAGES.\n" +
                this.greetingrecorded + "" +
                this.messagekept + "" +
                this.messagedeleted + "\n" +
                this.messagerecorded + "\n" +
                this.outputmessage;


        return output;
    }
}


