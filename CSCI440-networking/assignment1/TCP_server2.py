	import threading
import socket
import time
import pickle

IP = '192.168.1.105'
MAX = 65535
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
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((IP, self.port))
    while True:
      data, address = s.recvfrom(MAX)
      print 'Received Is Alive From ' , address
      f = "I'm alive"
      pickle.load(f)
      s.sendto(pickle.loads(f), address)#sends the pickled message


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
          print data.dump ##decodes the pickling
        except socket.timeout:
          print 'Need to remove server'
          pass #remove server from list as they did not respond

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)                   
bserver(50000).start()
isaliveserver(50001).start()
isalivetester().start()



