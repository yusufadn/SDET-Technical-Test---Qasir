<?php
$objA = array("a"=>10, "b"=>20, "c"=>30);
$objB = array("a"=>3, "c"=>6, "d"=>3);
$objC = [];
$objD = [];

//merge array has the same key
$objC = array_merge_recursive($objA, $objB);
foreach($objC as $key1 => $value1){
	//check if value is array
	if(is_array($value1)){
		$temp = 0;
		//combine value in array
		foreach($value1 as $key2 => $value2){
			$temp = $temp + $value2;
		}		
		$objD[$key1] = $temp;
	}
	else{
		$objD[$key1] = $value1;
	}
}
var_dump($objD);

