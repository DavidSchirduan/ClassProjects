<?php

include 'HeaderMenu.php';
include 'Connect.php';

//create a new view for quizzes, to be used in the UserUpdate script.
$query = 'DROP VIEW if exists `UserAnswers`';
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = 'CREATE VIEW UserAnswers AS
SELECT idQuizzes, name, idQuestions, text, answerChoice, idChoices, userChoice, Quizzes_idQuizzes, Questions_idQuestions
FROM Quizzes Qz, Questions Qs, Answers A, Quizzes_has_Questions QQ, Choices CC
WHERE Qz.idQuizzes = QQ.Quizzes_idQuizzes
AND Qs.idQuestions = QQ.Questions_idQuestions
AND A.idAnswers = Qs.idQuestions
AND CC.idChoices = QQ.Questions_idQuestions';
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
$points = 0;
echo'<table>';
echo'<tr><th>Question ID</th><th>Text</th><th>User Choice</th><th>Correct Answer</th><th>Result</th></tr>';

$query = "SELECT idQuestions, text, userChoice, answerChoice
FROM UserAnswers
WHERE idQuizzes ='" . $_REQUEST['quizID'] . "'";
//echo $query;
$result = mysql_query($query);
while ($row = mysql_fetch_assoc($result)) {
    $answer = $row['answerChoice'];
    $choice = $row['userChoice'];
    
    if ($answer<>$choice){
	$ouch = "WRONG";
    }
    else{
	$ouch = "correct!";
	$points += 1;
    }
    echo "<tr><td>" . $row['idQuestions'] . "</td><td>" . $row['text'] . "</td><td>" . $row['userChoice'] . "</td><td>" . $row['answerChoice'] . "</td><td>" . $ouch . "</td></tr>";
}
$numberQ = $_REQUEST['numQ'];

echo "<br><br>" . $_REQUEST['username'] . " took quiz " .  $_REQUEST['quizname'], " and scored ". ($points/$numberQ * 100) . " percent<br><br>";

?>
</table>

<a href="http://localhost/332Project/UserHome.php">Back to Users</a>
