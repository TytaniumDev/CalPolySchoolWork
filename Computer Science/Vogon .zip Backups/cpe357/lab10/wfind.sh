#!/bin/bash
# Made by Tyler Holland
# Lab 10

if [ $# -ne 1 ]
then
   echo "usage: $0 word"
   exit 1
fi

find ~/ -type f -exec grep --files-with-matches $1 {} \;
