


CC	:= gcc 
CFLAGS := -g -lm -Wall -Werror $(LABDEFS)

TARGETS := hi hello words fact testPoint testSortedPoints

# Make sure that 'all' is the first target
all: $(TARGETS)

clean:
	rm -rf core *.o *.out $(TARGETS)

realclean: clean
	rm -rf *~ *.bak


tags:
	etags *.c *.h

TURNIN := /lusr/bin/turnin
GRADER := impjdi
LAB_NAME := handin-372-labC
handin: handin.tar
	echo "Turning in handin.tar containing the following files:"
	tar tf handin.tar
	$(TURNIN) --submit $(GRADER) $(LAB_NAME) handin.tar


handin.tar: clean
	tar cf handin.tar `find . -type f | grep -v '^\.*$$' | grep -v '/CVS/' | grep -v '/\.svn/' | grep -v '/\.git/' | grep -v 'lab[0-9].*\.tar\.gz' | grep -v '/\~/' | grep -v 'C.html' | grep -v '/\.tar/'` 





# To keep things simple and obvious in the makefile
# I list the dependencies explicitly. For large
# projects with more interesting dependencies, it
# is better to generate them automatically.	
#  See 
#
#        Recursive Make Considered Harmful
#        http://aegis.sourceforge.net/auug97.pdf
#
# for an explanation (as well as a very nice discussion
# about structuring Makefiles for larger projects.
#
# Explicit dependencies instead, to keep things simple:
hi: hi.o
	$(CC) $(CFLAGS) -o hi hi.o

hi.o: hi.c
	$(CC) $(CFLAGS) -c -o hi.o hi.c


hello: hello.o
	$(CC) $(CFLAGS) -o hello hello.o

hello.o: hello.c
	$(CC) $(CFLAGS) -c -o hello.o hello.c

words: words.o
	$(CC) $(CFLAGS) -o words words.o

words.o: words.c
	$(CC) $(CFLAGS) -c -o words.o words.c

fact: fact.o
	$(CC) $(CFLAGS) -o fact fact.o

fact.o: fact.c
	$(CC) $(CFLAGS) -c -o fact.o fact.c

testPoint: testPoint.o point.o
	$(CC) $(CFLAGS) -o testPoint testPoint.o point.o

testPoint.o: testPoint.c point.h
	$(CC) $(CFLAGS) -c -o testPoint.o testPoint.c

point.o: point.c point.h
	$(CC) $(CFLAGS) -c -o point.o point.c

sortedPoints.o: sortedPoints.c sortedPoints.h point.h
	$(CC) $(CFLAGS) -c -o sortedPoints.o sortedPoints.c

testSortedPoints.o: testSortedPoints.c 
	$(CC) $(CFLAGS) -c -o testSortedPoints.o testSortedPoints.c

testSortedPoints: testSortedPoints.o point.o sortedPoints.o
	$(CC) $(CFLAGS) -o testSortedPoints testSortedPoints.o point.o sortedPoints.o


