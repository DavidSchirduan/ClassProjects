<?php

include 'HeaderMenu.php';
require 'Connect.php';

$query = "UPDATE Questions SET Answers_idAnswers=null WHERE Answers_idAnswers= '" . $_REQUEST["idAnswers"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}


$query = "DELETE from Answers WHERE idAnswers= '" . $_REQUEST["idAnswers"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'AnswerHome.php'</script>