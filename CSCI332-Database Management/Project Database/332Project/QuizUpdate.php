<?php
include 'HeaderMenu.php';
include 'Connect.php';

if(isset($_REQUEST['idQuizzes'])) {
    
$action = 'QuizApplyUpdate.php';
$query = "SELECT idQuizzes,name,numQuestions from Quizzes where idQuizzes = '" . $_REQUEST['idQuizzes']. "'";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
if ($row = mysql_fetch_assoc($result)) {
    	$origID = $row['idQuizzes'];   
	$origname = $row['name'];   
	$orignum = $row['numQuestions'];     		
}
mysql_close($connection);
}


?>

</br></br>
Edit User:
<table>
<form action="<?php echo $action;?>">
<tr><td>ID</td><td><input type="text" name="newID" value="<?php echo $origID;?>"/></td></tr>
<tr><td>Name</td><td><input type="text" name="newname" value="<?php echo $origname;?>"/></td></tr>
<tr><td>Number of Questions</td><td><input type="text" name="numQuestions" value="<?php echo $orignum;?>"/></td></tr>
<input type="hidden" name="origID"  value="<?php echo $origID;?>" />
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>



