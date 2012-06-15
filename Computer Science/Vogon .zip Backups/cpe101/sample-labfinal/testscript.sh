#!/bin/sh

TEST_DIR=/home/bellardo-101/sample-labfinal
EXEC_NAME=sample-labfinal

if [ ! -x $EXEC_NAME ] ; then
    echo "ERROR: $EXEC_NAME doesn't exist in this directory!"
    exit 0
fi

for base in `ls $TEST_DIR/*.in | sed -e sX.*/XX | sed -e s/\\.in//`; do
    echo Evaluating test case $base...
    cp -f $TEST_DIR/$base.in $TEST_DIR/$base.out .
    ./$EXEC_NAME < $TEST_DIR/$base.in > my_$base.out
    diff $TEST_DIR/$base.out my_$base.out
done
