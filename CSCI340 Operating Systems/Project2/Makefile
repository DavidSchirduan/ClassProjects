# Makefile for the CS:APP Shell Lab

TEAM = David Schirduan
VERSION = 1
DRIVER = ./sdriver.pl
TSH = ./tsh
TSHREF = ./tshref
TSHARGS = "-p"
CC = gcc
CFLAGS = -Wall -O2
FILES = $(TSH) ./myspin ./mysplit ./mystop ./myint ./fib ./handle ./mykill

all: $(FILES)

tsh: tsh.o util.o jobs.o
	$(CC) $(CFLAGS) tsh.o util.o jobs.o -o tsh


psh: psh.o util.o 
	$(CC) $(CFLAGS) psh.o util.o -o psh

handle: handle.o util.o
	$(CC) $(CFLAGS) handle.o util.o -o handle


##################
# Handin your work
##################
TAID = "PUT_TA_ID_HERE"

handin.tar: clean
	tar cf handin.tar `find . -type f | grep -v '^\.*$$' | grep -v '/CVS/' | grep -v '/\.svn/' | grep -v '/\.git/' | grep -v 'lab[0-9].*\.tar\.gz' | grep -v '/\~/' | grep -v 'tshref' | grep -v '/\.txt' | grep -v '/\.pl' |grep -v '/\.tar/'` 

TURNIN := /lusr/bin/turnin
GRADER := TBD-FIXME
LAB1_NAME := handin-439-shlab-1
LAB2_NAME := handin-439-shlab-2
LAB3_NAME := handin-439-shlab-3

handin-1: handin.tar
	echo "FIX MAKEFILE TO INCLUDE THE TA user ID for the cs machines"
	echo "Turning in handin.tar containing the following files:"
	tar tf handin.tar
	$(TURNIN) --submit $(GRADER) $(LAB1_NAME) handin.tar

handin-2: handin.tar
	echo "FIX MAKEFILE TO INCLUDE THE TA user ID for the cs machines"
	echo "Turning in handin.tar containing the following files:"
	tar tf handin.tar
	$(TURNIN) --submit $(GRADER) $(LAB2_NAME) handin.tar

handin-3: handin.tar
	echo "FIX MAKEFILE TO INCLUDE THE TA user ID for the cs machines"
	echo "Turning in handin.tar containing the following files:"
	tar tf handin.tar
	$(TURNIN) --submit $(GRADER) $(LAB3_NAME) handin.tar



##################
# Regression tests
##################

# Run tests using the student's shell program
test01:
	$(DRIVER) -t trace01.txt -s $(TSH) -a $(TSHARGS)
test02:
	$(DRIVER) -t trace02.txt -s $(TSH) -a $(TSHARGS)
test03:
	$(DRIVER) -t trace03.txt -s $(TSH) -a $(TSHARGS)
test04:
	$(DRIVER) -t trace04.txt -s $(TSH) -a $(TSHARGS)
test05:
	$(DRIVER) -t trace05.txt -s $(TSH) -a $(TSHARGS)
test06:
	$(DRIVER) -t trace06.txt -s $(TSH) -a $(TSHARGS)
test07:
	$(DRIVER) -t trace07.txt -s $(TSH) -a $(TSHARGS)
test08:
	$(DRIVER) -t trace08.txt -s $(TSH) -a $(TSHARGS)
test09:
	$(DRIVER) -t trace09.txt -s $(TSH) -a $(TSHARGS)
test10:
	$(DRIVER) -t trace10.txt -s $(TSH) -a $(TSHARGS)
test11:
	$(DRIVER) -t trace11.txt -s $(TSH) -a $(TSHARGS)
test12:
	$(DRIVER) -t trace12.txt -s $(TSH) -a $(TSHARGS)
test13:
	$(DRIVER) -t trace13.txt -s $(TSH) -a $(TSHARGS)
test14:
	$(DRIVER) -t trace14.txt -s $(TSH) -a $(TSHARGS)
test15:
	$(DRIVER) -t trace15.txt -s $(TSH) -a $(TSHARGS)
test16:
	$(DRIVER) -t trace16.txt -s $(TSH) -a $(TSHARGS)

# Run the tests using the reference shell program
rtest01:
	$(DRIVER) -t trace01.txt -s $(TSHREF) -a $(TSHARGS)
rtest02:
	$(DRIVER) -t trace02.txt -s $(TSHREF) -a $(TSHARGS)
rtest03:
	$(DRIVER) -t trace03.txt -s $(TSHREF) -a $(TSHARGS)
rtest04:
	$(DRIVER) -t trace04.txt -s $(TSHREF) -a $(TSHARGS)
rtest05:
	$(DRIVER) -t trace05.txt -s $(TSHREF) -a $(TSHARGS)
rtest06:
	$(DRIVER) -t trace06.txt -s $(TSHREF) -a $(TSHARGS)
rtest07:
	$(DRIVER) -t trace07.txt -s $(TSHREF) -a $(TSHARGS)
rtest08:
	$(DRIVER) -t trace08.txt -s $(TSHREF) -a $(TSHARGS)
rtest09:
	$(DRIVER) -t trace09.txt -s $(TSHREF) -a $(TSHARGS)
rtest10:
	$(DRIVER) -t trace10.txt -s $(TSHREF) -a $(TSHARGS)
rtest11:
	$(DRIVER) -t trace11.txt -s $(TSHREF) -a $(TSHARGS)
rtest12:
	$(DRIVER) -t trace12.txt -s $(TSHREF) -a $(TSHARGS)
rtest13:
	$(DRIVER) -t trace13.txt -s $(TSHREF) -a $(TSHARGS)
rtest14:
	$(DRIVER) -t trace14.txt -s $(TSHREF) -a $(TSHARGS)
rtest15:
	$(DRIVER) -t trace15.txt -s $(TSHREF) -a $(TSHARGS)
rtest16:
	$(DRIVER) -t trace16.txt -s $(TSHREF) -a $(TSHARGS)


# clean up
clean:
	rm -f $(FILES) *.o *~ *.bak *.BAK



