<?php

/*
 * Need to make ID unique, otherwise shenanagins!
 */

include 'HeaderMenu.php';
include 'Connect.php';

$action = 'NewCreator.php';

$query = "SELECT idCreators, name, password from Creators";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
echo'<table>';
echo'<tr><th>ID</th><th>Name</th><th> Password</th></tr>';


while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['idCreators'] . "</td><td>" . $row['name'] . "</td><td>" . $row['password'] . "</td>
	<td><a href='CreatorDelete.php?idCreators=" . $row['idCreators'] . "'>DELETE</a>" .
	"</td><td><a href='CreatorUpdate.php?idCreators=" . $row['idCreators'] . "'>UPDATE</a>" . 
         "</td></tr>";
}

?>
</table>

<br><br><br>

Add new User:
<table>
<form action="<?php echo $action;?>">

<tr><td>ID (int)</td><td><input type="text" name="idCreators"/></td></tr>
<tr><td>Name</td><td><input type="text" name="name"/></td></tr>
<tr><td>Password</td><td><input type="text" name="password"/></td></tr>
<input type="hidden" name="id"  value="<?php echo $_GET['id'];?>" />
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>