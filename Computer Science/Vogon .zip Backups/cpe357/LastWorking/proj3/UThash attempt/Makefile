#  Makefile for freq, Project 3
#  Last Modified: Wed Jan  20 21:10:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=freq

all:	$(ALL)

freq:	freq.c readwords.c wordtype.c freq.h uthash.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o freq freq.c readwords.c wordtype.c freq.h uthash.h

clean:
	rm -rf core* *.o *.gch $(ALL)
