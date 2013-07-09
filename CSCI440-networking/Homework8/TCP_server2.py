#David Schirduan
#Assignment 8 - modification of assignment to usign the python SSL library
#12-7-11

import threading
import socket
import time

IP = '192.168.1.105'
MAX = 443 #changed this to match the normal ssl port
knownservers = []

class bserver(threading.Thread):
  def __init__(self, port):
     super(bserver,self).__init__()
     self.port = port
  def run( self ):
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    while True:
      data, address = s.recvfrom(MAX)
      print 'received broadcast'
      knownservers.append(data)

class isaliveserver(threading.Thread):
  def __init__(self, port):
     super(isaliveserver,self).__init__()
     self.port = port
  def run( self ):
	s.listen((IP, port))
    s.bind((IP, self.port))
    while True:
      s.connect(server.split(";")[0],int(server.split(";")[1])))
      print 'Received Is Alive From ' , address
      #the added section below turns things over to the SSL library
      ca_certs_path = os.path.join(os.path.dirname(script_name), 'certfiles.crt') #had to make this point to the certfiles on my computer, but I couldn't find out which directory it was
      sslsock = ssl.wrap_socket(sock, ssl_version=ssl.PROTOCOL_SSLv3,
      cert_reqs=ssl.CERT_REQUIRED, ca_certs=ca_certs_path)
      s.sendto('I am alive', address)

class isalivetester(threading.Thread):
  def run( self ):
    while True:
      time.sleep(15)
      print 'timer fired'
      for server in knownservers:
        print 'Want to send to ',  server
        s.connect(server.split(";")[0],int(server.split(";")[1])))##changed this to connect for TCP
        try:
          s.settimeout(5)
          data, address = s.recvfrom(MAX)
          print 'Received Alive Response'
        except socket.timeout:
          print 'Need to remove server'
          pass #remove server from list as they did not respond

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)   
bserver(50000).start()
isaliveserver(50001).start()
isalivetester().start()



