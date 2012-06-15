#  Makefile for freq, Project 3
#  Last Modified: Wed Jan  20 21:10:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=mypgm

all:	$(ALL)

mypgm:	mypgm.c ops.c mypgm.h
	$(CC) $(CFLAGS) $(LDFLAGS) -lm -o mypgm ops.c mypgm.c mypgm.h

clean:
	rm -rf core* *.o *.gch $(ALL)
