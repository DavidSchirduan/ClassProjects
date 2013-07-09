<?php

include 'HeaderMenu.php';
require 'Connect.php';

$query = "DELETE from Groups_has_Users WHERE Users_idUsers= '" . $_REQUEST["idUsers"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = "UPDATE Choices SET Users_idUsers=null WHERE Users_idUsers= '" . $_REQUEST["idUsers"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = "DELETE from Users WHERE idUsers= '" . $_REQUEST["idUsers"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'UserHome.php'</script>