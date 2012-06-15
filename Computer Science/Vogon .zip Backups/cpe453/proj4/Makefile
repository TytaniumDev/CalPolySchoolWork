#  CPE 453
#  -------------------
#  makefile for proj4
#
#  Last Modified: 6/01/10
#  @author Brig Bagley (bbagley) and Tyler Holland (tyhollan)
CC=gcc
CFLAGS=-Wall -g -ansi -pedantic -D_XOPEN_SOURCE=500
LDFLAGS=

ALL=  minls minget

all:	$(ALL)

minls:	minls.c main.h
	 $(CC) $(CFLAGS) $(LDFLAGS) -o $@  minls.c

minget:	minget.c main.h
	 $(CC) $(CFLAGS) $(LDFLAGS) -o $@  minget.c
clean:
	 rm -f core* *.o *.gch $(ALL)

