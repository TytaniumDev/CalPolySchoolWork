#  Makefile for Hello : Project 5
#  Used by student: Tyler Holland
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -g
LDFLAGS=

ALL=hello

all:	$(ALL)

hello:	hello.o
	$(CC) -g -o $@ $^

hello.o:	hello.c
	$(CC) $(CFLAGS) $(LDFLAGS) -c -o $@ $<

test:	hello
	@echo Testing hello...
	@./hello
	@echo done.

clean:
	rm -f hello.o *~ TAGS
