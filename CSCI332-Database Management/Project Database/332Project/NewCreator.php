<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "INSERT into Creators (idCreators, name, password)
	   VALUES ('" . $_REQUEST["idCreators"] . "', '" . $_REQUEST["name"] . "', '" . $_REQUEST["password"] . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'CreatorHome.php'</script>