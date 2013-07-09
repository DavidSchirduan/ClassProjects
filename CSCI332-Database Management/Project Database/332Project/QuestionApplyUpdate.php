<?php
include 'HeaderMenu.php';
include 'Connect.php';

$query = "UPDATE Questions SET idQuestions = '" . $_REQUEST['newID'] . "',"
  . "text = '" . $_REQUEST['questionText'] . "'"
  . " where idQuestions = '" . $_REQUEST['origID'] . "'";
//echo $query;
//exit;
  
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

mysql_close($connection);

?>
<script>window.location = 'QuestionHome.php'</script>
