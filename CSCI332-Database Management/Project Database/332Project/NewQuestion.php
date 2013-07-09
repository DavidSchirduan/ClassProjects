<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "INSERT into Questions (idQuestions, text)
	   VALUES ('" . $_REQUEST["idQuestions"] . "', '" . $_REQUEST["questionText"] . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'QuestionHome.php'</script>