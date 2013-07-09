<?php

/*
 * Need to make ID unique, otherwise shenanagins!
 */

include 'HeaderMenu.php';
include 'Connect.php';

$action = 'NewChoice.php';

$query = "SELECT idChoices, userChoice from Choices";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
echo'<table>';
echo'<tr><th>ID</th><th>User Choice</th></tr>';


while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['idChoices'] . "</td><td>". $row['userChoice'] . "</td>
	<td><a href='ChoiceDelete.php?idChoices=" . $row['idChoices'] . "'>DELETE</a>" .
	"</td><td><a href='ChoiceUpdate.php?idChoices=" . $row['idChoices'] . "'>UPDATE</a>" . 
         "</td></tr>";
}

?>
</table>

<br><br><br>

Create a new Question:
<form action="<?php echo $action;?>"><br>
ID (int):<input type="text" name="idChoices" /><br>
User Choice:<input type="text" name="userChoice" /><br>
<input type="hidden" name="id"  value="<?php echo $_GET['idChoices'];?>"/><br>
<input type="submit" value="Submit" />
</form>
