<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "INSERT into Choices (idChoices, userChoice)
	   VALUES ('" . $_REQUEST["idChoices"] . "', '" . $_REQUEST["userChoice"] . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'ChoiceHome.php'</script>