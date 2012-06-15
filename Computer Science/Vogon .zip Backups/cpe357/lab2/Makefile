#  Makefile for lab02 lab assignment
#  Last Modified: Mon Jan  15 13:21:00 PST 2010
#  @author Kevin O'Gorman
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=lab02

all:	$(ALL)

# If you have a "lab02.h" header file, its name should be added after lab02.c
d2u:	lab02.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $<

clean:
	rm -rf core* *.o *.gch $(ALL)
