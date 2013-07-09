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


echo'<table>';
echo'<tr><th>Quiz Name</th><th>Question ID</th><th>Text</th><th>Correct Answer</th></tr>';

$query = "SELECT name,idQuestions, text, answerChoice from QuizQuestionsAnswers where idQuizzes = '" . $_REQUEST['idQuizzes'] . "'";
$result = mysql_query($query);
while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['name'] . "</td><td>" . $row['idQuestions'] . "</td><td>" . $row['text'] . "</td><td>" . $row['answerChoice'] . "</td></tr>";
}
?>
</table>

<a href="http://localhost/332Project/QuizHome.php">Back to Quizzes</a>
