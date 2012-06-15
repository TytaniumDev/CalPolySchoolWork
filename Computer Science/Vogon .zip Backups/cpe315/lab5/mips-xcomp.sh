#!/bin/bash
# Bash script to automate cross compile
# $1: input c file name
# $2: output simulator file name

# CHANGE ME to be the location that you extracted the tar file to
binDir="/home/tyhollan/cpe315/lab5/bin"

# Forces command line paramters
if [ $# != 2 ]
then
    echo "usage: $0 <input c file> <output sim name>"
    exit
fi

# cross compile
$binDir/mips-elf-gcc $1 -static -msoft-float -o $1.obj

# generate simulation file
$binDir/mips-elf-objdump -D $1.obj | $binDir/gensimcode > $2
