import socket, sys

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.setsockopt(socket.SOL_SOCKET,socket.SO_BROADCAST, 1)

MAX = 65535
PORT = 50000
# ip = 10.210.36.109
# subnet = 255.255.252.0
IP = '192.168.1.105'
MESSAGE = '10.210.36.109;50001'

s.sendto(MESSAGE, (IP, PORT))
#data, address = s.recvfrom(MAX)
