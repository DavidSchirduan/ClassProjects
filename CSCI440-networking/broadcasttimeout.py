import threading
import socket

IP = '127.0.0.1'
MAX = 65535

class myThread(threading.Thread):
    def __init__(self, port):
        super(myThread,self).__init__()
        self.port = port
    def run( self ):
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.settimeout(10)
        s.bind((IP, self.port))
    while True:
        try:
            data, address = s.recvfrom(MAX)
            print 'The client at' , address, 'says' , repr(data)
            s.sendto('Your data was %d bytes' % len(data), address)
            i = 5000
            while i < 5050:
                s.sendto('This is my message', (IP, i))
                i+=1
           
        except socket.timeout:
            print 'socket timeout thread on port %d' % self.port
            i = 5000
            while i<5100:
                try:
                    s.sendto('lookiloo', (IP, i))
                    i+=1
                except:
                    i+=1

myThread(5003).start()
myThread(5001).start()
