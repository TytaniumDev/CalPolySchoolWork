#  Makefile for lab4
#  Last Modified: Tue Jan  26 22:25:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=test1 test2 test3 testme testgetline

all:	$(ALL)

test1:	lab4.c mylinea.o myline.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o test1 lab4.c mylinea.o myline.h
	
test2:	lab4.c mylineb.o myline.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o test2 lab4.c mylineb.o myline.h
	
test3:	lab4.c mylinec.o myline.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o test3 lab4.c mylinec.o myline.h
	
testme:	lab4.c myline.c myline.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o testme lab4.c myline.c myline.h
	
testgetline: lab4getline.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o testgetline lab4getline.c  

clean:
	rm -rf core* *.o *.gch $(ALL)
