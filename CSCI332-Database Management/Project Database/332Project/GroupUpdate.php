<?php
include 'HeaderMenu.php';
include 'Connect.php';

if(isset($_REQUEST['idGroups'])) {
    
$action = 'GroupApplyUpdate.php';
$query = "SELECT idGroups, name, description from Groups where idGroups = '" . $_REQUEST['idGroups']. "'";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
if ($row = mysql_fetch_assoc($result)) {
    	$origID = $row['idGroups'];   
	$origname = $row['name'];   
	$origdescr = $row['description'];   
}
mysql_close($connection);
}


?>

</br></br>
Edit Question:<br><br><br>
<table>
<form action="<?php echo $action;?>">
<tr><td>ID</td><td><input type="text" name="newID" value="<?php echo $origID;?>"/></td></tr><tr><td>
<?php
include 'Connect.php';

$quizquery = "SELECT idCreators, name from Creators";
$quizresult = mysql_query($quizquery);
if (!$quizresult) {
    die('Invalid query: ' . mysql_error());

}
echo"Creator:</td><td> <select name='creator'>";
echo "<option value='null' name='creatorchoice'>No Creator</option>";
while ($quizrow = mysql_fetch_assoc($quizresult)) {
    echo "<option value='" . $quizrow['idCreators'] . "' name='craetorchoice'>" . $quizrow['name'] . "</option>";
}
echo '</select>'
?>

    </td></tr><tr><td>Name</td><td><input type="text" name="newname" value="<?php echo $origname;?>"/></td></tr>
Question Text: <br><textarea rows="4" cols="50" name="description"><?php echo $origdescr?></textarea> <br>
<input type="hidden" name="origID"  value="<?php echo $origID;?>" />
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>



