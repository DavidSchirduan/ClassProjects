<?php
include 'HeaderMenu.php';
include 'Connect.php';

if(isset($_REQUEST['idQuestions'])) {
    
$action = 'QuestionApplyUpdate.php';
$query = "SELECT idQuestions,text from Questions where idQuestions = '" . $_REQUEST['idQuestions']. "'";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
if ($row = mysql_fetch_assoc($result)) {
    	$origID = $row['idQuestions'];   
	$origtext = $row['text'];   
}
mysql_close($connection);
}


?>

</br></br>
Edit Question:
<table>
<form action="<?php echo $action;?>">
<tr><td>ID</td><td><input type="text" name="newID" value="<?php echo $origID;?>"/></td></tr>
Question Text: <br><textarea rows="4" cols="50" name="questionText"><?php echo $origtext?></textarea> <br>
<input type="hidden" name="origID"  value="<?php echo $origID;?>" />
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>



