<?php
	$op = $_POST["op"];
	if($op=="addUser"){
		$userName = $_POST["userName"];
		$userPass = $_POST["userPass"];
		$userRole = $_POST["userRole"];
	}else{
		$day= $_POST["day"];
		$hr= $_POST["day"];
		$skill= $_POST["day"];
	}
	$str = shell_exec($cmd);
?>
