#written by David Schirduan, with assistance from Networking with Python
#12-7-11
#assignment6.py
from email.mime.base import MIMEBase 
from email.mime.multipart import MIMEMultipart 
from email.mime.text import MIMEText 
from email import utils, encoders 
import mimetypes
import email.utils
from email.message import Message
import sys, smtplib
import getpass, poplib



#the first part of the program generates some default mail for the mail folder in root.

file1.open('message1.txt', 'w')

text = """Hello,
This is a test message from Chapter 12. I hope you enjoy it!
-- Anonymous"""
msg = Message()
msg['To'] = 'recipient@example.com'
msg['From'] = 'Test Sender <sender@example.com>'
msg['Subject'] = 'Test Message, Chapter 12'
msg.set_payload(text)



#attachment setup
def attachment(filename): 
    fd = open(filename, 'rb') 
    mimetype, mimeencoding = mimetypes.guess_type(filename) 
    if mimeencoding or (mimetype is None): 
        mimetype = 'application/octet-stream' 
    maintype, subtype = mimetype.split('/') 
    if maintype == 'text': 
        retval = MIMEText(fd.read(), _subtype=subtype) 
    else: 
        retval = MIMEBase(maintype, subtype) 
        retval.set_payload(fd.read()) 
        encoders.encode_base64(retval) 
    retval.add_header('Content-Disposition', 'attachment', 
        filename = filename) 
    fd.close() 
    return retval 
 
#attaches attachements, and finishes message
msg.attach(body) 
for filename in sys.argv[1:]: 
    msg.attach(attachment(filename)) 

file1.write(msg)
file1.close()

#uses SMTP to send the object to the server.
#parses command line args
if len(sys.argv) < 4:
    print "usage: %s server fromaddr toaddr [toaddr...]" % sys.argv[0]
    sys.exit(2)
server, fromaddr, toaddrs = sys.argv[1], sys.argv[2], sys.argv[3:]
#opens up the created file
message = file1.open('message.txt', 'r')

#creates SMTP object, attaches the message to it, and sends the message to the recipients.
s = smtplib.SMTP(server) #the gmail SMTP server is smtp.gmail.com
s.sendmail(fromaddr, toaddrs, message)

#Support for POP3 through google, simply tests pop3 by listing contents of mailbox

hostname = "pop.gmail.com"
user = "davidschirduan@gmail.com
passwd = getpass.getpass()
p = poplib.POP3_SSL(hostname) #have to use ssl for google
try:
    p.user(user)
    p.pass_(passwd)
except poplib.error_proto, e:
    print "Login failed:", e
else:
    status = p.stat()
    print "You have %d messages totaling %d bytes" % status
finally:
    p.quit()
