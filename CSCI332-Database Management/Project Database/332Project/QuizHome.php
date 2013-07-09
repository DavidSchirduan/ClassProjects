<?php

/*
 * Need to make ID unique, otherwise shenanagins!
 */

include 'HeaderMenu.php';
include 'Connect.php';

$action = 'NewQuiz.php';

$query = "SELECT idQuizzes, name, numQuestions from Quizzes";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
echo "<br><br><br>";


echo'<table>';
echo'<tr><th>ID</th><th>Name</th><th>Number of Questions</th></tr>';


while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['idQuizzes'] . "</td><td>" . $row['name'] . "</td><td>" . $row['numQuestions'] . "</td>
	<td><a href='QuizDelete.php?idQuizzes=" . $row['idQuizzes'] . "'>DELETE</a>" .
	"</td><td><a href='QuizUpdate.php?idQuizzes=" . $row['idQuizzes'] . "'>UPDATE</a>" .
	"</td><td><a href='GenerateQuestions.php?idQuizzes=" . $row['idQuizzes'] . "'>Generate Questions</a>" . 
	 "</td><td><a href='QuizView.php?idQuizzes=" . $row['idQuizzes'] . "'>View Questions and Answers</a>" . 
         "</td></tr>";
}

?>
</table>

<br><br><br>

Add new Quiz:
<table>
<form action="<?php echo $action;?>">

<tr><td>ID (int)</td><td><input type="text" name="idQuizzes" /></td></tr>
<tr><td>Name</td><td><input type="text" name="name"/></td></tr>
<tr><td>Number of Questions</td><td><input type="text" name="numQuestions"/></td></tr>
<input type="hidden" name="id"  value="<?php echo $_GET['idQuizzes'];?>"/>
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>