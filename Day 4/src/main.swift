var hello = "Hello"
var world: String = " World"
var msg = hello + world
print(msg)

func double(num: Int) -> Bool{

    let numStr = String(num)

    for i in 0...4{
        if(numStr[numStr.index(numStr.startIndex, offsetBy: i)] == numStr[numStr.index(numStr.startIndex, offsetBy: (i+1))]){
            return true
        }
    }

    return false

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