#!/bin/bash
#
# Written by Kevin O'Gorman as part of Lab 7 A

function spin {
  let=$1
  d=$(date | tr -d \\n  )
  echo -n $d $let
  sleep 1
  tput cr
}

echo
while true
do
  spin '|'
  spin /
  spin -
  spin \\
done
