/*David Schirduan
 * 12-7-11
 * Re-submittal of assignment 5 in Java
 * a simple email program in Java
 * 
 * I followed some of the tutorials that I found at Javaworld.com to use javamail
 */

package com.lotontech.mail;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class simplejavaEmail {

	  /**
	    * Assuming you have downloaded and installed the Javamail program
	    * The program accepts command line arguments for the variables, and creates the message
	    */
	  public static void main(String args[])
	  {
	    try
	    {
	      String smtpServer=args[0];
	      String to=args[1];
	      String from=args[2];
	      String subject=args[3];
	      String body=args[4];
	      //the part below sends the message with the needed info.
	      send(smtpServer, to, from, subject, body);
	    }
	    catch (Exception ex)
	    {
	      System.out.println("Usage: java com.lotontech.mail.SimpleSender"
	       +" smtpServer toAddress fromAddress subjectText bodyText");
	    }
	    System.exit(0);
	  }
}
