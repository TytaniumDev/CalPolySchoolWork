#  Makefile for Schedule : Project 1
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=schedule

all:	$(ALL)

schedule:	schedule.c schedule.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^

clean:
	rm -rf core* *.o *.gch $(ALL)
