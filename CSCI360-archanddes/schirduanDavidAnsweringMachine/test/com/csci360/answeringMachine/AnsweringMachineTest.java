/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csci360.answeringMachine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Created by David Schirduan
 * with assistance from Goup UML
 * Answering Machine test class
 */
public class AnsweringMachineTest {

    AnsweringMachine instance;

    public AnsweringMachineTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
        {
        }

    @AfterClass
    public static void tearDownClass() throws Exception
        {
        }

    @Before
    public void setUp() {

    instance = new AnsweringMachine();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of recordMessage method, of class AnsweringMachine.
     */
    @Test
    public void testRecordMessage()
        {
        System.out.println("recordMessage");
        Message mess = new Message("this is a test");
        instance.recordMessage(mess);
        // TODO review the generated test code and remove the default call to fail.
        assert(instance.messages.contains(mess));        //tests to make sure the message is in there
    }

    /**
     * Test of playMessages method, of class AnsweringMachine.
     */
    @Test
    public void testPlayMessages()
        {
        Message mess = new Message("this is a test");
        instance.recordMessage(mess);
        System.out.println("playMessages");
        instance.playMessages();
        // TODO review the generated test code and remove the default call to fail.
        assert(!instance.messages.isEmpty());
        }

    /**
     * Test of recordGreeting method, of class AnsweringMachine.
     */
    @Test
    public void testRecordGreeting()
        {
        System.out.println("recordGreeting");
        Message mess = new Message("I am Jacks liver");
        instance.recordGreeting(mess);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(instance.greeting);
        }

    /**
     * Test of playGreeting method, of class AnsweringMachine.
     */
    @Test
    public void testPlayGreeting()
        {
        Message mess = new Message("I am Jacks liver");
        instance.recordGreeting(mess);
        System.out.println("playGreeting");
        instance.playGreeting();
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(instance.greeting);
        }

    /**
     * Test of keepMessage method, of class AnsweringMachine.
     */
    @Test
    public void testKeepMessage()
        {
        System.out.println("keepMessage");
        instance.keepMessage();
        // TODO review the generated test code and remove the default call to fail.
        }

    /**
     * Test of deleteMessage method, of class AnsweringMachine.
     */
    @Test
    public void testDeleteMessage()
        {
        System.out.println("deleteMessage");
        int i = 0;
        Message mess = new Message("test1");
        Message mess2 = new Message("test2");
        instance.recordMessage(mess);
        instance.recordMessage(mess2);
        instance.deleteMessage(i);
        // TODO review the generated test code and remove the default call to fail.
        assertNull(instance.messages.get(i));
        }

}