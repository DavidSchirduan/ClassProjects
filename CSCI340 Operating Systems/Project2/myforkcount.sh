#! /bin/bash

if [ $# -lt 1 ]
then
    echo "USAGE: `basename $0` [0-13]"
    exit 1
fi

if [ $1 -lt 0 -o $1 -gt 13 ]
then
    echo "USAGE: `basename $0` [0-13]"
    exit 1
fi

# get the number of forks since boot (before fib call)
r1="`vmstat -f`"

# run the recursive 'forking' fib program
echo "fib($1) = `./fib $1`"

# get the number of forks since boot (after fib call)
r2="`vmstat -f`"

# turn space delimited return values into array of strings (only want number)
ar1=($r1)
ar2=($r2)

# compute difference of fork call numbers (bc is arbitrary precision calc.)
echo -n "number of forks = "       # -n means no newline at the end
echo "${ar2[0]} - ${ar1[0]}" | bc

exit 0
