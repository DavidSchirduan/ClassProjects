#David Schirduan
#Assignment 1
#I was unable to get these working on the computer lab machines because the computers use
# python 3.5

import socket, sys

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)

MAX = 65535
PORT = 1060

IP = socket.gethostbyname(socket.gethostname())

print IP

s.bind(('', PORT))
print 'Listening for broadcasts at', s.getsockname()
while !heard:
	data, address = s.recvfrom(MAX)
	print 'The client at %r says: %r' % (address, data)
	s.sendto('KeepAlive', (network, PORT))


