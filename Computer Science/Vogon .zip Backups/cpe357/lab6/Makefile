#  Makefile for linestats, Project 2
#  Last Modified: Wed Jan  20 21:10:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=unpackbits

all:	$(ALL)

unpackbits:	unpackbits.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^

clean:
	rm -rf core* *.o *.gch $(ALL)
