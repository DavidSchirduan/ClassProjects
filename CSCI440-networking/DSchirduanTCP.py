#Writen by David Schirduan, with help from Josh Moore

import threading
import socket, sys

IP = '127.0.0.1'
MAX = 65535

## somehow I need to get the program to use 2 seperate ports for sendign and receiving. and get each instance to use an individual port


knownlist = []

class myThread(threading.Thread):
  def __init__(self, port1, port2):
	super(myThread,self).__init__()
	self.port1 = port1
	self.port2 = port2
  def run( self ):
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.settimeout(2)
    s.bind((IP, self.port1))
    s2 = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s2.settimeout(2)
    s2.bind((IP, self.port2))
    knownlist = []
    while True:
        try:
            for a in knownlist:
                s.sendto('Ah, ah, ah, staying alive',(IP,int(a[10])))
            data, address = s.recvfrom(MAX)
            knownlist.append(address)
            print data
            
        except socket.timeout:
			print 'Timed out, starting messages to known servers'
			i = 50000
			while i < 50010:
				try:
					s2.sendto('This is me searching for you',(IP, i))
					data,address = s.recvfrom(MAX)
					print str(self.port), ' found a server at ', s.getsockname()
					if not (i in knownlist):
                                            knownlist.append(i)
					i+=1
				except socket.timeout:
					#print 'No server found, moving onto', str(i)
					i+=1


myThread(50001,50002).start()
