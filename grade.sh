CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

file='./student-submission/ListExamples.java'
testfile='./TestListExamples.java'
testlib='./lib'

if [[ -f $file ]];
then
    echo "Received $file"
else
    echo  "$file not received"
    exit
fi

destination='./grading-area'
cp $file $destination
cp $testfile $destination
cp -r $testlib $destination

cd grading-area

javac -cp $CPATH *.java
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > test-result.txt

if [[ $? -eq 0 ]];
then
    echo "java command failed"
else
    echo "tests run successfully"
fi

cat test-result.txt
