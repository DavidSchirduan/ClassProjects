<?php

/*
 * Need to make ID unique, otherwise shenanagins!
 */

include 'HeaderMenu.php';
include 'Connect.php';

$action = 'NewUser.php';

$query = "SELECT idUsers, name, password from Users";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}


echo'<table>';
echo'<tr><th>ID</th><th>Name</th><th>Password</th><th/><th/><th/><th>Join Group</th></tr>';



while ($row = mysql_fetch_assoc($result)) {
    echo "<tr><td>" . $row['idUsers'] . "</td><td>" . $row['name'] . "</td><td>" . $row['password'] . "</td>
	<td><a href='UserDelete.php?idUsers=" . $row['idUsers'] . "'>DELETE</a>" .
	"</td><td><a href='UserUpdate.php?idUsers=" . $row['idUsers'] . "'>UPDATE</a>" .
	    	"</td><td><a href='UserSelectQuiz.php?name=".$row['name'] . "&idUsers=" . $row['idUsers'] . "'>TAKE QUIZ</a>" . 
         "</td><td>";
	    //---------------------select group form----------------	
$groupquery = 'SELECT idGroups, name from Groups';
$groupresult = mysql_query($groupquery);
if (!$groupresult) {
    die('Invalid query: ' . mysql_error());

}
echo "<form action='UserGroup.php'>";
echo"<select name='groupid'>";
echo "<option value='null' name='groupchoice'>no group</option>";
while ($grouprow = mysql_fetch_assoc($groupresult)) {
    echo "<option value='" . $grouprow['idGroups'] . "' name='groupchoice'>" . $grouprow['name'] . "</option>";
}
echo '</select><input type="hidden" name="userid"  value="'. $row['idUsers'] .'" /><input type="submit" value="Join" /></form>';
	    //----------end form----------------------
	    echo "</td></tr>";
}

?>
</table>

<br><br><br>

Add new User:
<table>
<form action="<?php echo $action;?>" id=userForm>

<tr><td>ID (int)</td><td><input type="text" name="idUsers"/></td></tr>
<tr><td>Name</td><td><input type="text" name="name"/></td></tr>
<tr><td>Password</td><td><input type="text" name="password"/></td></tr>
<input type="hidden" name="id"  value="<?php echo $_GET['id'];?>" />
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>