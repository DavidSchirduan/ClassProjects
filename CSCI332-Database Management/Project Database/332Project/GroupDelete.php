<?php

include 'HeaderMenu.php';
require 'Connect.php';

$query = "DELETE from Groups_has_Users WHERE Groups_idGroups= '" . $_REQUEST["idGroups"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

$query = "DELETE from Groups WHERE idGroups= '" . $_REQUEST["idGroups"] . "'";
//echo $query;
//exit;

$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}

?>

<script>window.location = 'GroupHome.php'</script>