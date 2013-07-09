<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "INSERT into Quizzes (idQuizzes, name, numQuestions)
	   VALUES ('" . $_REQUEST["idQuizzes"] . "', '" . $_REQUEST["name"] . "', '" . $_REQUEST["numQuestions"] . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'QuizHome.php'</script>