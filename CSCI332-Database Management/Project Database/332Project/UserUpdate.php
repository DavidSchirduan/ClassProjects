<?php
include 'HeaderMenu.php';
include 'Connect.php';

if(isset($_REQUEST['idUsers'])) {
    
$action = 'UserApplyUpdate.php';
$query = "SELECT idUsers,name,password from Users where idUsers = '" . $_REQUEST['idUsers']. "'";
$result = mysql_query($query);
if (!$result) {
    die('Invalid query: ' . mysql_error());
}
if ($row = mysql_fetch_assoc($result)) {
    	$origID = $row['idUsers'];   
	$origname = $row['name'];   
	$origpassword = $row['password'];     		
}}?>
<table>
<form action="<?php echo $action;?>">
<tr><td>ID</td><td><input type="text" name="newID" value="<?php echo $origID;?>"/></td></tr>
<tr><td>Name</td><td><input type="text" name="newname" value="<?php echo $origname;?>"/></td></tr>
<tr><td>Password</td><td><input type="text" name="newpassword" value="<?php echo $origpassword;?>"/></td></tr>

<input type="hidden" name="origID"  value="<?php echo $origID;?>" /><tr><td>
</td></tr>
<br><br><br>

<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form>
</table>

