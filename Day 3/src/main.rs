use std::fs;

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

	println!("{}", overlap(((-10, 0), (10, 0)), ((-10, 5), (-10, -5))));
}

fn overlap(line1:((i32, i32), (i32, i32)), line2:((i32, i32), (i32, i32))) -> bool{

	

}