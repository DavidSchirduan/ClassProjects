<?php
include 'HeaderMenu.php';
include 'Connect.php';

if(isset($_REQUEST['idAnswers'])) {
    
$action = 'AnswerApplyUpdate.php';
$query = "SELECT idAnswers,answerChoice from Answers where idAnswers = '" . $_REQUEST['idAnswers']. "'";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
if ($row = mysql_fetch_assoc($result)) {
    	$origID = $row['idAnswers'];   
	$origchoice = $row['answerChoice'];   
}
mysql_close($connection);
}


?>

</br></br>
Edit User:
<table>
<form action="<?php echo $action;?>">
<tr><td>ID</td><td><input type="text" name="newID" value="<?php echo $origID;?>"/></td></tr>
<tr><td>Correct Answer</td><td><input type="text" name="newchoice" value="<?php echo $origchoice;?>"/></td></tr>
<input type="hidden" name="origID"  value="<?php echo $origID;?>" />
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>



