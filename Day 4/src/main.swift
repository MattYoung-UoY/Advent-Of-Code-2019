var hello = "Hello"
var world: String = " World"
var msg = hello + world
print(msg)

func double(num: Int) -> Bool{

    let numStr = String(num)

    if(numStr.count == 1){
        return false;
    }else if(numStr.count == 2){
        return (numStr[numStr.index(numStr.startIndex, offsetBy: 0)] == numStr[numStr.index(numStr.startIndex, offsetBy: 1)]);
    }else{

        for i in 2...numStr.count{
            if(numStr[numStr.index(numStr.startIndex, offsetBy: i-2)] == numStr[numStr.index(numStr.startIndex, offsetBy: i-1)]){
                if(!(numStr[numStr.index(numStr.startIndex, offsetBy: i-1)] == numStr[numStr.index(numStr.startIndex, offsetBy: i)])){
                    return false;
                }else{ 
                    return true && double(num: Int(String(numStr.suffix(numStr.count-2))) ?? -1);
                }
            }
        }

        return false

    }

}

func ascending(num: Int) -> Bool{

    let numStr = String(num)

    for i in 0...4{
        if(numStr[numStr.index(numStr.startIndex, offsetBy: i)] > numStr[numStr.index(numStr.startIndex, offsetBy: (i+1))]){
            return false
        }
    }

    return true

}

func main(){

    let start = 356261
    let end = 846303

    var possibilities = [Int]()

    for i in start...end{
        if(double(num: i)){
            if(ascending(num: i)){
                possibilities += [i]
                print(i)
            }
        }
    }

    print(possibilities.count)

}

main()