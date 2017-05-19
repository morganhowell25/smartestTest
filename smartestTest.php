<?php
	$op = $_POST["op"];
	if($op=="pullTests"){
		$tid = $_POST["tid"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $tid";
	}else if($op=="pullTestLO"){
		$pincode = $_POST["pincode"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $pincode";
	}else if($op=="updateTestLOs"){
		$pincode = $_POST["pincode"];
		$cat1 = $_POST["cat1"];
		$cat2 = $_POST["cat2"];
		$right = $_POST["right"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $pincode $cat1 $cat2 $right";
	}else if($op=="viewStudentScores"){
		$pincode = $_POST["pincode"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $pincode";
	}else if($op=="pullStudentGradedTest"){
		$id = $_POST["id"];
		$pincode = $_POST["pincode"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $id $pincode";
	}else if($op=="updateDepartmentLOs"){
		$cat1 = $_POST["cat1"];
		$cat2 = $_POST["cat2"];
		$right = $_POST["right"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $cat1 $cat2 $right";
	}else if($op=="pullTest"){
		$pincode = $_POST["pincode"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $pincode";
	}else if($op=="saveGradedTest"){
		$sid = $_POST["sid"];
		$pincode = $_POST["pincode"];
		$gt = $_POST["gt"];
		$score = $_POST["score"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $sid $pincode $gt $score";
	}else if($op=="addUser"){
		$userName = $_POST["userName"];
		$userPass = $_POST["userPass"];
		$userRole = $_POST["userRole"];
		print("Made it into php file with $op $userName $userPass $userRole");
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $userName $userPass $userRole";
	}else if($op=="pullUserList"){
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op";
	}else if($op=="pullUInfo"){
		$uname = $_POST["uname"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $uname";
	}else if($op=="resetPWD"){
		$newPass = $_POST["newPass"];
		$userID = $_POST["userID"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $newPass $userID";
	}else if($op=="saveTest"){
		$pincode = $_POST["pincode"];
		$teacherID = $_POST["teacherID"];
		$myTest = $_POST["myTest"];
		$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $pincode $teacherID $myTest";
	}else if($op=="pullTakenTestList"){
                $id = $_POST["id"];
                $cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $id";
        }else if($op=="uploadOneLO"){
                $cat1 = $_POST["cat1"];
		$cat2 = $_POST["cat2"];
                $cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $cat1 $cat2";
        }else if($op=="checkUname"){
                $uname = $_POST["uname"];
                $cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $uname";
        }else if($op=="pullDepartmentLOs"){
                $cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op";
        }else if($op=="pullID"){
		$uname = $_POST["uname"];
                $cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar smartesttestserver.server $op $uname";
        }
	
	$str = shell_exec($cmd);
	print($str);
?>
