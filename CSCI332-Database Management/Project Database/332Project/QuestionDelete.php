<?php

include 'HeaderMenu.php';
require 'Connect.php';

$query = "DELETE from Quizzes_has_Questions WHERE Questions_idQuestions= '" . $_REQUEST["idQuestions"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = "DELETE from Questions WHERE idQuestions= '" . $_REQUEST["idQuestions"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'QuestionHome.php'</script>