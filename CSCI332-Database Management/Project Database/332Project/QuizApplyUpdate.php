<?php
include 'HeaderMenu.php';
include 'Connect.php';

$query = "UPDATE Quizzes SET name = '" . $_REQUEST['newname'] . "',"
  . "numQuestions = '" . $_REQUEST['numQuestions'] . "',"
  . "idQuizzes = '" . $_REQUEST['newID'] . "'"
  . " where idQuizzes = '" . $_REQUEST['origID'] . "'";
//echo $query;
//exit;
  
$result = mysql_query($query);

if (!$result) {
    die('Invalid query: ' . mysql_error());
}

mysql_close($connection);

?>
<script>window.location = 'QuizHome.php'</script>
