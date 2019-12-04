use std::fs;
use std::cmp;

fn main(){

	let data = fs::read_to_string("inputs.txt").expect("Unable to read file");

	let mut inputs = Vec::new();

	for input in data.split("#"){
		inputs.push(input);
	}

	let mut start = (0, 0);
	let mut end = (0, 0);

	let mut wire1:Vec<((i32, i32), (i32, i32))> = Vec::new();

	for symbol in inputs[0].split(","){
		let chars:Vec<char> = symbol.chars().collect();

		let mut distStr:String = "".to_string();
		for i in 1..chars.len(){
			distStr.push_str(&chars[i].to_string());
		}

		let dist: i32 = distStr.parse().unwrap();

		match chars[0]{
			'U' => 
				end.1 = start.1 + dist,
			'D' => 
				end.1 = start.1 - dist,
			'L' => 
				end.0 = start.0 - dist,
			'R' => 
				end.0 = start.0 + dist,
			_ => panic!(),
		};

		let points:((i32, i32), (i32, i32)) = (start, end);
		wire1.push(points);

		start = end;
	}

	start = (0, 0);
	end = (0, 0);

	let mut wire2:Vec<((i32, i32), (i32, i32))> = Vec::new();

	for symbol in inputs[1].split(","){
		let chars:Vec<char> = symbol.chars().collect();

		let mut distStr:String = "".to_string();
		for i in 1..chars.len(){
			distStr.push_str(&chars[i].to_string());
		}
		let dist = distStr.parse::<i32>().unwrap();
		match chars[0]{
			'U' => 
				end.1 = start.1 + dist,
			'D' => 
				end.1 = start.1 - dist,
			'L' => 
				end.0 = start.0 - dist,
			'R' => 
				end.0 = start.0 + dist,
			_ => panic!(),
		};

		let points:((i32, i32), (i32, i32)) = (start, end);
		wire2.push(points);

		start = end;

	}

	let mut intersections: Vec<(i32, i32)> = Vec::new();

	for line1 in &wire1{
		for line2 in &wire2{
			let intersectInfo: (bool, (i32, i32)) = intersect(&line1, &line2);
			if(intersectInfo.0){
				intersections.push(intersectInfo.1);
			}
		}
	}

	let mut minDist:i32 = 1000000000;

	for intersection in intersections{
		let distVal = (intersection.0).abs() + (intersection.1).abs();
		if distVal < minDist{
			minDist = distVal;
		}
	}

	println!("{}", minDist);

}

fn intersect(line1:&((i32, i32), (i32, i32)), line2:&((i32, i32), (i32, i32))) -> (bool, (i32, i32)){

	if((line1.0).0 == (line1.1).0){
		//line1 x vals same. Vertical line
		if((line2.0).0 == (line2.1).0){
			//Line2 also vertical
			return (false, (0, 0));
		}else{
			//line1 vert. line2 horiz.
			let x = (line1.0).0;
			let y = (line2.0).1;

			let minx = cmp::min((line2.0).0, (line2.1).0);
			let maxx = cmp::max((line2.0).0, (line2.1).0);

			let miny = cmp::min((line1.0).1, (line1.1).1);
			let maxy = cmp::max((line1.0).1, (line1.1).1);

			if(x >= minx && x <= maxx){
				//x is on horizontal
				if(y >= miny && y <= maxy){
					//y is on vertical
					//Therefore intersection
					return (true, (x, y));
				}
			}
		}
	}else if((line1.0).1 == (line1.1).1){
		//line1 y vals same. Horizontal line
		if((line2.0).1 == (line2.1).1){
			//Line2 also horizontal
			return (false, (0, 0));
		}else{
			//line 1 horiz. line 2 vert.
			let x = (line2.0).0;
			let y = (line1.0).1;

			let minx = cmp::min((line1.0).0, (line1.1).0);
			let maxx = cmp::max((line1.0).0, (line1.1).0);

			let miny = cmp::min((line2.0).1, (line2.1).1);
			let maxy = cmp::max((line2.0).1, (line2.1).1);

			if(x >= minx && x <= maxx){
				//x is on horizontal
				if(y >= miny && y <= maxy){
					//y is on vertical
					//Therefore intersection
					return (true, (x, y));
				}
			}
		}

	}else{
		//Ruh Roh Raggy!!!
		panic!();
	}

	return (false, (0, 0));

}