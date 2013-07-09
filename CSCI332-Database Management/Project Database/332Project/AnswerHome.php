<?php

/*
 * Need to make ID unique, otherwise shenanagins!
 */

include 'HeaderMenu.php';
include 'Connect.php';

$action = 'NewAnswer.php';

$query = "SELECT idAnswers, answerChoice from Answers";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
echo'<table>';
echo'<tr><th>ID</th><th>Correct Answer</th></tr>';


while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['idAnswers'] . "</td><td>". $row['answerChoice'] . "</td>
	<td><a href='AnswerDelete.php?idAnswers=" . $row['idAnswers'] . "'>DELETE</a>" .
	"</td><td><a href='AnswerUpdate.php?idAnswers=" . $row['idAnswers'] . "'>UPDATE</a>" . 
         "</td></tr>";
}

?>
</table>

<br><br><br>

Create a new Question:
<form action="<?php echo $action;?>"><br>
ID (int):<input type="text" name="idAnswers" /><br>
Correct Answer:<!--Make this a drop-down--><input type="text" name="answerChoice" /><br>
<input type="hidden" name="id"  value="<?php echo $_GET['idQuestions'];?>"/><br>
<input type="submit" value="Submit" />
</form>
