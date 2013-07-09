<?php

include 'HeaderMenu.php';
include 'Connect.php';

//create a new view for quizzes, to be used in the UserUpdate script.
$query = 'DROP VIEW if exists `QuizQuestionsAnswers`';
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = 'CREATE VIEW QuizQuestionsAnswers AS
SELECT idQuizzes, name, idQuestions, text, answerChoice, Quizzes_idQuizzes, Questions_idQuestions
FROM Quizzes Qz, Questions Qs, Answers A, Quizzes_has_Questions QQ
WHERE Qz.idQuizzes = QQ.Quizzes_idQuizzes
AND Qs.idQuestions = QQ.Questions_idQuestions
AND A.idAnswers = Qs.idQuestions';
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

if(isset($_REQUEST['idQuizzes'])) {
    
$action = 'QuizApplyUpdate.php';
$query = "SELECT idQuizzes,name,numQuestions from Quizzes where idQuizzes = '" . $_REQUEST['idQuizzes']. "'";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
if ($row = mysql_fetch_assoc($result)) {
    	$origID = $row['idQuizzes'];   
	$origname = $row['name'];   
	$orignum = $row['numQuestions'];     		
}
echo "<br>Quiz " . $origname . " has room for " . $orignum . " total questions<br><br>";

//check to see if the quiz has max questions
$query = "SELECT COUNT(idQuestions) FROM QuizQuestionsAnswers WHERE idQuizzes= ".$origID;
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
$data = mysql_fetch_array($result);
$quizcount =  $data[0];

if ($quizcount >= $orignum){
    echo "Quiz " . $origname ." already has " . $orignum . " questions. Stop trying to fight the system!";
}
else{

echo 'Generating questions...<br><br>';

//I need to make ID's more specific, or I need to keep adding on to them
//make i start at the count.

$query = "SELECT MAX(idQuestions) FROM Questions";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$data = mysql_fetch_array($result);
$maxID =  $data[0];

for ($i=0; $i<$orignum; $i++){
    
 //Chooses a random number 
 $num = Rand (1,10); 
 //Based on the random number, gives a quote 
 switch ($num)
 {
 case 1:
$question = "This is also a question";
 break;
 case 2:
$question = "Is this a question?";
 break;
 case 3:
$question = "What is the average velocity of an unleaden sparrow?";
 break;
 case 4:
$question = "How much wood would a woodchuck chuck if a wouldchuck could CHUCK NORRIS?";
 break;
 case 5:
$question = "What was I saying?";
 break;
 case 6:
$question = "This is a question";
 break;
 case 7:
$question = "What was I saying?";
 break;
 case 8:
$question = "Who am I?";
 break;
 case 9:
$question = "Can I stop making up questions now?";
 break;
 case 10:
$question = "I like trains?";
 } 
 
 $newid = $i+$maxID+1; //this prevents me from creating duplicate IDs, with a little cushion
 
 //Create answers first, to tie in

$answer = chr(97 + mt_rand(0, 7));//randomly generate answers
$query = "INSERT into Answers (idAnswers, answerChoice)
	   VALUES ('" . $newid . "', '" . $answer . "')";
//echo $query;
//exit;

//then create questions
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
 
$query = "INSERT into Questions (idQuestions, text, Answers_idAnswers)
	   VALUES ('" . $newid . "', '" . $question . "', '" . $newid . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}



$query = "INSERT INTO `332Project`.`Quizzes_has_Questions` (
`Quizzes_idQuizzes` ,
`Questions_idQuestions`
)
VALUES (
'$origID', '$newid'
)";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
}
echo '<br>Done generating Questions and Answers, now tying them into Quiz....<br>';
echo '<br>Done!';

mysql_close($connection);
}
}

echo '<br><a href="http://localhost/332Project/QuizHome.php">Back to Quizzes</a>'
?>
