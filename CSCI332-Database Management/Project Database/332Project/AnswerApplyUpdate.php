<?php
include 'HeaderMenu.php';
include 'Connect.php';

$query = "UPDATE Answers SET answerChoice = '" . $_REQUEST['newchoice'] . "',"
  . "idAnswers = '" . $_REQUEST['newID'] . "'"
  . " where idAnswers = '" . $_REQUEST['origID'] . "'";
//echo $query;
//exit;
  
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

mysql_close($connection);

?>
<script>window.location = 'AnswerHome.php'</script>
