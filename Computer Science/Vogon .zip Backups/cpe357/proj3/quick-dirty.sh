#!/bin/bash
# Written by Kevin O'Gorman
# Copyright 2010 Kevin O'Gorman, all rights reserved.

# usage: quick-dirty.sh N filename ...
# or     quick-dirty.sh N dir
#
# produces a list of the N most common words in the files,
# along with the count of each one's occurrences.
# Only alpha sequences at least 4 characters long are considered.

if [ $# -lt 2 ]
then
  echo "usage: $0 limit {file ... | dir}"
  exit 1
fi

if [ $1 -lt 1 ]
then
  echo "usage: $0 limit {file ... | dir}"
  exit 1
fi

num=$1
shift

if [ $num = --help ]
then
  echo "usage: $0 limit {file ... | dir}"
  echo "STUDENTS should fill in the rest of this."
  exit 0
elif [ $num = --version ]
then
  echo "Winter 2010"
  echo "Copyright 2010 Kevin O'Gorman"
  echo "Professor's shell-script version of a word counter"
  exit 0
fi

(                         # Use this subshell as the data source of the pipeline

  if [ -d $1 ]              # is it a directory
  then
    for i in $1/*           # Handle every entry in the directory
    do
      if [ -f $i ]       # pick the regular files
      then
        cat $i           # put all files in the directory into the pipeline
        # do not even warn about non-files.  Just skip them.
      fi
    done
  else
    for i in $*           # Handle the rest of the arguments
    do
      if [ -f $i ]
      then
        cat $i           # put all files in the directory into the pipeline
      else
        # put this warning message into stderr, not into the pipeline
        echo "Warning: $i is not a regular file" 1>&2
      fi
    done
  fi
) |                         # put the file(s) into the pipeline
    sed 's/[^A-Za-z]/ /g' | # turn non-alphas into blanks
    tr ' \t' '\n\n' |       # turn blanks and tabs into newlines
    sed 's/^...$//g' |      # empty 3-letter lines
    sed 's/^..$//g' |       # empty 2-letter lines
    sed 's/^.$//g' |        # empty 1-letter lines
    grep -v '^$' |          # drop empty lines
                            # truncate long words
    perl -n -e 'chomp; if (m/\w{21}/) {printf "%s%06d\n",substr($_,0,20),length($_);} else {print $_, "\n";}' |
    tr '[A-Z]' '[a-z]' |    # go lowercase
    sort |                  # sort the words
    uniq -c |               # count duplicates
    sort -r -n |            # sort on the counts (numeric descending)
                            # Rearrange the line
    perl -n -e 'm/(\d+) *(\w*)/; printf("%26s %d\n", $2, $1);' |
    head -$num                # trim to N most common
