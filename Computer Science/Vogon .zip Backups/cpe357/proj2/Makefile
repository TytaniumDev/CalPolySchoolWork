#  Makefile for linestats, Project 2
#  Last Modified: Wed Jan  20 21:10:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=linestats

all:	$(ALL)

linestats:	driver.c myline.c myline.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o linestats driver.c myline.c myline.h

clean:
	rm -rf core* *.o *.gch $(ALL)
