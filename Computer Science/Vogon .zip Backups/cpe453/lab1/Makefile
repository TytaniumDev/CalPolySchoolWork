#  Makefile for Pipeit, Lab 1
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=pipeit

all:	$(ALL)

pipeit:	pipeit.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^

clean:
	rm -rf core* *.o *.gch $(ALL)
