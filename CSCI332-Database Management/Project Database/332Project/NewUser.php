<?php

include 'HeaderMenu.php';
require 'Connect.php';


$query = "INSERT into Users (idUsers, name, password)
	   VALUES ('" . $_REQUEST["idUsers"] . "', '" . $_REQUEST["name"] . "', '" . $_REQUEST["password"] . "')";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'UserHome.php'</script>