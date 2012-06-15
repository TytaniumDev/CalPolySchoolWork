#  Makefile for Lab 10, Unix Commands
#  Last Modified: Mon March  8 21:10:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=wfind

all:	$(ALL)

wfind:	wfind.sh
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^

clean:
	rm -rf core* *.o *.gch $(ALL)
