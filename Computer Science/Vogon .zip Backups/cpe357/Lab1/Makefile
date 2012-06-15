#  Makefile for d2u lab assignment
#  Last Modified: Mon Jan  4 13:20:45 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=d2u

all:	$(ALL)

# If you have a "d2u.h" header file, its name should be added after d2u.c
d2u:	d2u.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $<

clean:
	rm -rf core* *.o *.gch $(ALL)
