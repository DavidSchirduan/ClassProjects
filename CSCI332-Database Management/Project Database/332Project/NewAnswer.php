<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "INSERT into Answers (idAnswers, answerChoice)
	   VALUES ('" . $_REQUEST["idAnswers"] . "', '" . $_REQUEST["answerChoice"] . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'AnswerHome.php'</script>