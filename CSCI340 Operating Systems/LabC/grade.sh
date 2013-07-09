#!/bin/sh

echo
echo ====================================================
echo grade.sh does some very simple tests on the text
echo output of your program. Passing grade.sh is
echo not a guarantee that your code is correct or
echo that it will receive a good grade. You 
echo should also do your own tests.
echo
echo Attempting to mislead the grading script
echo is not permitted and will be treated as
echo academic dishonesty.
echo ====================================================
echo

make -k
passed=0
failed=0

echo "Test 1 Hello"
if ./hello | grep "Hello world" > /dev/null
then
   passed=`expr 1 + $passed`
   echo OK
else
   failed=`expr 1 + $failed`
   echo WRONG
fi


echo "Test 2 Words"
./words testing 1 2 3 > words.out
if  grep "testing" words.out > /dev/null
then
  if grep "3" words.out > /dev/null
  then
      str1=`cat words.out | wc -l | awk '{print $1;}'`
      str2=`echo 4`
      if [ "$str1"  = "$str2" ]
      then 
          passed=`expr 1 + $passed`
          echo OK
      else
         failed=`expr 1 + $failed`
        echo WRONG
     fi
   else
   failed=`expr 1 + $failed`
   echo WRONG
   fi
else
   failed=`expr 1 + $failed`
   echo WRONG
fi


echo "Test 3 Fact"
if ./fact 9 | grep 362880 > /dev/null
then
   passed=`expr 1 + $passed`
   echo a OK
else
   failed=`expr 1 + $failed`
   echo a WRONG
fi
if ./fact 12 | grep 479001600 > /dev/null
then
   passed=`expr 1 + $passed`
   echo b OK
else
   failed=`expr 1 + $failed`
   echo b WRONG
fi
if ./fact 1.2 | grep "Huh?" > /dev/null
then
   passed=`expr 1 + $passed`
   echo c OK
else
   failed=`expr 1 + $failed`
   echo c WRONG
fi
if ./fact 0 | grep "Huh?" > /dev/null
then
   passed=`expr 1 + $passed`
   echo d OK
else
   failed=`expr 1 + $failed`
   echo d WRONG
fi
if ./fact -9 | grep "Huh?" > /dev/null
then
   passed=`expr 1 + $passed`
   echo e OK
else
   failed=`expr 1 + $failed`
   echo e WRONG
fi
if ./fact foo | grep "Huh?" > /dev/null
then
   passed=`expr 1 + $passed`
   echo f OK
else
   failed=`expr 1 + $failed`
   echo f WRONG
fi


echo "Test 4 Point"
if ./testPoint | grep "OK" > /dev/null
then
   passed=`expr 1 + $passed`
   echo OK
else
   failed=`expr 1 + $failed`
   echo WRONG
fi

echo "Test 5 SortedPoint"
if ./testSortedPoints | grep "OK" > /dev/null
then
   passed=`expr 1 + $passed`
   echo OK
else
   failed=`expr 1 + $failed`
   echo WRONG
fi




echo "Output passed: $passed  Output failed: $failed"


    

