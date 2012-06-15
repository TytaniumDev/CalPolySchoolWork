#  Makefile for detab project 1
#  Last Modified: Wed Jan  13 22:25:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=detab

all:	$(ALL)

# If you have a "detab.h" header file, its name should be added after detab.c
detab:	detab.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $<

clean:
	rm -rf core* *.o *.gch $(ALL)
