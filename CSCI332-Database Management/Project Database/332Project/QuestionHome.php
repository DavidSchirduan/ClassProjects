<?php

/*
 * Need to make ID unique, otherwise shenanagins!
 */

include 'HeaderMenu.php';
include 'Connect.php';

$action = 'NewQuestion.php';

$query = "SELECT idQuestions, text from Questions";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
echo'<table>';
echo'<tr><th>ID</th><th>Text</th></tr>';


while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['idQuestions'] . "</td><td><textarea rows='4' cols='50'>" . $row['text'] . "</textarea></td>
	<td><a href='QuestionDelete.php?idQuestions=" . $row['idQuestions'] . "'>DELETE</a>" .
	"</td><td><a href='QuestionUpdate.php?idQuestions=" . $row['idQuestions'] . "'>UPDATE</a>" . 
         "</td></tr>";
}

?>
</table>

<br><br><br>

Create a new Question:

<form action="<?php echo $action;?>"><br>
ID (int)<input type="text" name="idQuestions" /><br>
Question Text: <br><textarea rows="4" cols="50" name="questionText">Question Text Here</textarea>
<input type="hidden" name="id"  value="<?php echo $_GET['idQuestions'];?>"/><br>
<input type="submit" value="Submit" />
</form>
