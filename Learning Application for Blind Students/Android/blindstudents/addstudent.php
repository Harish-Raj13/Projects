<?php 

$connect=mysql_connect("localhost","root","");
mysql_select_db("blindstudents",$connect);


 $ename = $_GET['pname'];
 $eemail = $_GET['pemail'];
 $econtact = $_GET["pcontact"];
 $gender = $_GET["gender"];
 
 $email = $_GET["email"];
 $edob = $_GET["edob"];


 $epassword = $_GET["epassword"];

if($connect)
{

				$sqlCheckUname = mysql_query("SELECT * FROM sturegister WHERE regnum LIKE '$eemail'");
				$u_name_query =  mysql_num_rows($sqlCheckUname);

				if($u_name_query > 0)
				{
					echo "User name allready used type another one";
				}
				else
				{
					

					$sql_register = mysql_query("INSERT INTO sturegister VALUES ('','$ename','$eemail','$email','$econtact','$gender','$edob','$epassword')");

					if($sql_register)
					{
						echo "You are registered successfully";
					}	
					else
					{
						echo "Failed to register you account";
					}
				}

}
else
{
echo "Connection Error";
}

?>
