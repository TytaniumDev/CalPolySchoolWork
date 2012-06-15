CC 	= gcc

CFLAGS  = -Wall -g -I ../include

LD 	= gcc

LDFLAGS  = -Wall -g 

PUBFILES =  README  hungrymain.c  libPLN.a  liblwp.a  libsnakes.a  lwp.h\
	    numbersmain.c  snakemain.c  snakes.h

TARGET =  pn-cs453@hornet:Given/asgn2

PROGS	= snakes nums hungry

SNAKEOBJS  = snakemain.o 

HUNGRYOBJS = hungrymain.o 

NUMOBJS    = numbersmain.o

OBJS	= $(SNAKEOBJS) $(HUNGRYOBJS) $(NUMOBJS) 

SRCS	= snakemain.c numbersmain.c

HDRS	= 

EXTRACLEAN = core $(PROGS)

all: 	$(PROGS)

allclean: clean
	@rm -f $(EXTRACLEAN)

clean:	
	rm -f $(OBJS) *~ TAGS
	
lwp:	lwp.c lwp.h
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^

snakes: snakemain.o libPLN.a libsnakes.a
	$(LD) $(LDFLAGS) -o snakes snakemain.o -L. -lncurses -lsnakes -lPLN

hungry: hungrymain.o libPLN.a libsnakes.a
	$(LD) $(LDFLAGS) -o hungry hungrymain.o -L. -lncurses -lsnakes -lPLN

nums: numbersmain.o libPLN.a 
	$(LD) $(LDFLAGS) -o nums numbersmain.o -L. -lPLN

hungrymain.o: lwp.h snakes.h

snakemain.o: lwp.h snakes.h

numbermain.o: lwp.h

liblwp.a: lwp.c
	gcc -c lwp.c
	ar r liblwp.a lwp.o
	rm lwp.o
	
libPLN.a: lwp.c
	gcc -c lwp.c
	ar r libPLN.a lwp.o
	rm lwp.o

pub:
	scp $(PUBFILES) $(TARGET)

