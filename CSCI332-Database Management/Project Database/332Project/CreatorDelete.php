<?php

include 'HeaderMenu.php';
require 'Connect.php';

$query = "UPDATE Groups SET Creators_idCreators=null WHERE Creators_idCreators= '" . $_REQUEST["idCreators"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = "DELETE from Creators WHERE idCreators= '" . $_REQUEST["idCreators"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}


?>

<script>window.location = 'CreatorHome.php'</script>