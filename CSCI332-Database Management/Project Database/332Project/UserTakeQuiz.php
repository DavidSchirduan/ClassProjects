<?php
include 'HeaderMenu.php';
include 'Connect.php';

//drop the previous procedure
//create a proceure to do this
$query = "drop PROCEDURE if exists getQuizQuestions";
$quizid = $_REQUEST['quizlist'];
$userID = $_REQUEST['userID'];

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

//create a proceure to do this
$query = "CREATE PROCEDURE getQuizQuestions(IN quizID INT)
   BEGIN
SELECT idQuestions  FROM QuizQuestionsAnswers WHERE idQuizzes = quizID;
   END ";

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
    
//Generate some choices for that user
//__________________________Quiz Bit___________________________________-
$query = "SELECT name,numQuestions FROM Quizzes WHERE idQuizzes= ".$quizid;
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
while ($row = mysql_fetch_assoc($result)) {
    $quizname = $row['name']; 
    $numQ = $row['numQuestions'];
}

echo "<br>".$_REQUEST['username']." is taking the quiz '" . $quizname . "', which has " . $numQ . " questions<br><br>...";


echo 'Submitting choices...<br><br>';
//need all the id #'s of the questions in that quiz. then create choices with the same ID.
//select the quiz, return all the questions for that quiz
$query = "call getQuizQuestions(". $_REQUEST['quizlist'] . ")";
///exit;
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$array = array();

while ($row = mysql_fetch_assoc($result)) {
    array_push($array, $row['idQuestions']);
}
mysql_close($connection);


//var_dump($array);
include 'Connect.php';

//first delete any questions that exist
foreach ($array as $value) {
$userchoice = chr(97 + mt_rand(0, 7));//randomly generate answers
$query = "DELETE FROM Choices
WHERE idChoices=$value";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
}

foreach ($array as $value) {
$userchoice = chr(97 + mt_rand(0, 7));//randomly generate answers
$query = "INSERT into Choices (idChoices, userChoice, Users_idUsers)
	   VALUES ('" . $value . "', '" . $userchoice . "', '" . $userID . "')";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
}
mysql_close($connection);

//create a new view to show scores and result

echo 'Comparing Answers...<br><br>';

echo 'Calculating score...<br><br>';


$action = 'AnswerView.php';
?>
<form action="<?php echo $action;?>">

<input type="hidden" name="username"  value="<?php echo $_REQUEST['username'];?>"/>
<input type="hidden" name="quizname"  value="<?php echo $quizname;?>"/>
<input type="hidden" name="quizID"  value="<?php echo $quizid;?>"/>
<input type="hidden" name="numQ"    value="<?php echo $numQ;?>"/>

<input type="submit" value="See Results" /></td></tr>
</form>