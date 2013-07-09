<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "DELETE from Choices WHERE idChoices= '" . $_REQUEST["idChoices"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'ChoiceHome.php'</script>