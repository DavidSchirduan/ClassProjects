<?php

include 'HeaderMenu.php';
require 'Connect.php';

$query = "DELETE from Quizzes_has_Questions WHERE Quizzes_idQuizzes= '" . $_REQUEST["idQuizzes"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = "DELETE from Quizzes WHERE idQuizzes= '" . $_REQUEST["idQuizzes"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'QuizHome.php'</script>