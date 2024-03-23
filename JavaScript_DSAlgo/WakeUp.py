#!/usr/bin/env python 
import socket 
s=socket.socket(socket.AF_INET, socket.SOCK_DGRAM) 
s.sendto('\xff'*6+'\x0c\x37\x96\x1e\x88\xab'*16, ('10.28.102.9', 80))
