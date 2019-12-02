<?php 

for($i = 0; $i < 100; $i++){
	for($j = 0; $j < 100; $j++){
		if(runMachine($i, $j) == 19690720){
			echo (100 * $i) + $j;
			$i = 100;
			$j = 100;
		}
	}
}

function runMachine($addr1, $addr2){
	$tape = array(1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,19,6,23,2,6,23,27,2,27,9,31,1,5,31,35,1,35,10,39,2,39,9,43,1,5,43,47,2,47,10,51,1,51,6,55,1,5,55,59,2,6,59,63,2,63,6,67,1,5,67,71,1,71,9,75,2,75,10,79,1,79,5,83,1,10,83,87,1,5,87,91,2,13,91,95,1,95,10,99,2,99,13,103,1,103,5,107,1,107,13,111,2,111,9,115,1,6,115,119,2,119,6,123,1,123,6,127,1,127,9,131,1,6,131,135,1,135,2,139,1,139,10,0,99,2,0,14,0);

	$tape[1] = $addr1;
	$tape[2] = $addr2;
	
	$counter = 0;

	while(($counter <= count($tape)) and (!($tape[$counter] == 99))){
		$symbol = $tape[$counter];
		if($symbol == 1){
			$tape[$tape[$counter + 3]] = $tape[$tape[$counter + 1]] + $tape[$tape[$counter + 2]];
			$counter+=4;
		}else if($symbol == 2){
			$tape[$tape[$counter + 3]] = $tape[$tape[$counter + 1]] * $tape[$tape[$counter + 2]];
			$counter+=4;
		}else{
			echo "\n\n" . $counter . "\nCRASH!!!\n\n\n";
			$counter += 10000000000000;
		}
	}
	
	return $tape[0];
}

?> 