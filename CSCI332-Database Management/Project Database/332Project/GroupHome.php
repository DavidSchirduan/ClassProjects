<?php

/*
 * Need to make ID unique, otherwise shenanagins!
 */

include 'HeaderMenu.php';
include 'Connect.php';

$action = 'NewGroup.php';

$query = "SELECT idGroups, name, description, Creators_idCreators from Groups";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}



echo'<table>';
echo'<tr><th>ID</th><th>Name</th><th>Creator ID</th><th>Description</th><th></th><th></th><th>View/Drop Group Members</th></tr>';


while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['idGroups'] . "</td><td>" . $row['name'] . "</td><td>" . $row['Creators_idCreators'] . "</td><td><textarea rows='4' cols='50'>" . $row['description'] . "</textarea></td>
	<td><a href='GroupDelete.php?idGroups=" . $row['idGroups'] . "'>DELETE</a>" .
	"</td><td><a href='GroupUpdate.php?idGroups=" . $row['idGroups'] . "'>UPDATE</a></td><td>";
	   	    //---------------------Delete User form----------------	    
$groupquery = "SELECT U.name, U.idUsers
FROM Users U, Groups_has_Users GU, Groups G
WHERE G.idGroups = GU.Groups_idGroups
AND U.idUsers = GU.Users_idUsers
AND GU.Groups_idGroups=". $row['idGroups'];
$groupresult = mysql_query($groupquery);
if (!$groupresult) {
    die('Invalid query: ' . mysql_error());

}
    
echo "<form action='GroupDrop.php'>";
echo"<select name='userid'>";
echo "<option value='null' name='groupchoice'>View Users</option>";
while ($grouprow = mysql_fetch_assoc($groupresult)) {
    echo "<option value='" . $grouprow['idUsers'] . "' name='userchoice'>" . $grouprow['name'] . "</option>";
}
echo '</select><input type="hidden" name="groupid"  value="'. $row['idGroups'] .'" /><input type="submit" value="Drop" /></form>';
	    //----------end form---------------------- 
echo "</td></tr>";
}

?>
</table>

<br><br><br>

Create a new Group:

<form action="<?php echo $action;?>"><br>
ID (int)<input type="text" name="idGroups" /><br>
<?php
$quizquery = "SELECT idCreators, name from Creators";
$quizresult = mysql_query($quizquery);
if (!$quizresult) {
    die('Invalid query: ' . mysql_error());

}
echo"Creator: <select name='creator'>";
echo "<option value='null' name='creatorchoice'>No Creator</option>";
while ($quizrow = mysql_fetch_assoc($quizresult)) {
    echo "<option value='" . $quizrow['idCreators'] . "' name='craetorchoice'>" . $quizrow['name'] . "</option>";
}
echo '</select>'
?>
<br>
Name<input type="text" name="newname" /><br>
Description: <br><textarea rows="4" cols="50" name="description">This is a new Group</textarea>
<input type="hidden" name="id"  value="<?php echo $_GET['idGroups'];?>"/><br>
<input type="submit" value="Submit" />
</form>
