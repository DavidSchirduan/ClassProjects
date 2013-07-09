<!DOCTYPE html>
<?php
include ('HeaderMenu.php');
include ('Connect.php');

echo '<br>Welcome to Survey Weasel [God Mode Enabled]';
echo '</br> Click on one of the links below to create a user or creator. </br>';

    ?>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
	<!--need two options, one to create a new user, one to create a new Creator. just make them simple box scripts-->  
	<br>
	<br>
	As God, you can do whatever you feel like doing, and have complete control over the entire site and database. Enjoy! 
	<br>
	<br>
	<table> 
	    <tr>
		<th>Create Creator:</th><th>Create User:</th>
	    </tr>
	    <tr><td>
	<form method="post" action="NewCreator.php">
	ID: <input type="text" name="idCreators" value="000"><br>
	Name: <input type="text" name="name" value="Tyler Durden"><br>
	Password: <input type="password" name="password" value="Jack"><br>
	<input type="submit" value="Submit"></form>
	</td>
	<td>	
	<form method="post" action="NewUser.php">
	ID: <input type="text" name="idUsers" value="000"><br>
	Name: <input type="text" name="name" value="Robert Paulson"><br>
	Password: <input type="password" name="password" value="Password"><br>
	<input type="submit" value="Submit"></form> 
	</td>
	</tr><th>
	<tr><th>Create Quiz:</th><th>Create Question:</th></tr>
	<tr><td>
	Create Quiz:	<br>	
	<form method="post" action="NewQuiz.php">
	ID: <input type="text" name="idQuizzes" value="000"><br>
	Name: <input type="text" name="name" value="Fight Club Rules"><br>
	Number of Questions: <input type="text" name="numQuestions" value="5"><br>
	<input type="submit" value="Submit"></form>
	    </td>
	<td>
	Create Question:	<br>	
	<form method="post" action="NewQuestion.php">
	ID: <input type="text" name="idQuestions" value="000"><br>
	Question Text: <br><textarea rows="4" cols="50" name="questionText">How much wood would a woochuck chuck if a woodchuck could CHUCK NORRIS!</textarea> <br>
	<input type="submit" value="Submit"></form></td>
	</tr>
	<tr><th>Create a new Answer:</th><th>Create a new Group:</th></tr><tr><td>
	<form action="NewAnswer.php"><br>
	ID (int):<input type="text" name="idAnswers" /><br>
	Correct Answer:<input type="text" name="answerChoice" /><br>
	<input type="hidden" name="id"  value="<?php echo $_GET['idQuestions'];?>"/><br>
	<input type="submit" value="Submit" />
	</form>
	    </td><td>
		Create a new Group:

<form action="NewGroup.php"><br>
ID (int)<input type="text" name="idGroups" /><br>

<?php
$quizquery = "SELECT idCreators, name from Creators";
$quizresult = mysql_query($quizquery);
if (!$quizresult) {
    die('Invalid query: ' . mysql_error());

}
echo"Creator: <select name='creator'>";
echo "<option value='null' name='creatorchoice'>No Creator</option>";
while ($quizrow = mysql_fetch_assoc($quizresult)) {
    echo "<option value='" . $quizrow['idCreators'] . "' name='craetorchoice'>" . $quizrow['name'] . "</option>";
}
echo '</select>'
?>

<br>Name<input type="text" name="newname" value="Testgroup"/><br>
Description: <br><textarea rows="4" cols="50" name="description">This is a new Group</textarea>
<br><input type="submit" value="Submit" />
</form>
	    </td>
	</tr>
    </table>
    </body>
</html>
