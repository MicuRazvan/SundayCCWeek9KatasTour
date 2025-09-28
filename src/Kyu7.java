import java.util.HashMap;
import java.util.Map;

//https://www.codewars.com/kata/57e17750621bca9e6f00006f
//Colored Hexes!
/*
You're looking through different hex codes, and having trouble telling the difference between #000001 and #100000

We need a way to tell which is red, and which is blue!

That's where you create hex color !!!

It should read an RGB input, and return whichever value (red, blue, or green) is of greatest concentration!

But, if multiple colors are of equal concentration, you should return their mix!
red + blue = magenta
green + red = yellow
blue + green = cyan
red + blue + green = white

One last thing, if the string given is empty, or has all 0's, return black!

Examples:

codes = "087 255 054" -> "green"
codes = "181 181 170" -> "yellow"
codes = "000 000 000" -> "black"
codes = "001 001 001" -> "white"
 */
public class Kyu7 {
    public static String hexColor(String codes) {
        if(codes.isEmpty()){
            return "black";
        }

        String mapKey = "";
        Map<String, String> colors = new HashMap<>();
        colors.put("red + blue", "magenta");
        colors.put("red + green", "yellow");
        colors.put("green + blue", "cyan");
        colors.put("red + green + blue", "white");
        colors.put("black", "black");
        colors.put("red", "red");
        colors.put("green", "green");
        colors.put("blue", "blue");

        String[] numbers = codes.split(" ");
        int nr1 = Integer.parseInt(numbers[0]), nr2 = Integer.parseInt(numbers[1]), nr3 = Integer.parseInt(numbers[2]);
        int max = findMax(nr1, nr2, nr3);

        if(nr1 == 0 && nr2 == 0 & nr3 == 0){
            return "black";
        }

        if(nr1 == max){
            mapKey += "red";
        }
        if(nr2 == max){
            if(!mapKey.isEmpty()){
                mapKey += " + ";
            }
            mapKey += "green";
        }
        if(nr3 == max){
            if(!mapKey.isEmpty()){
                mapKey += " + ";
            }
            mapKey += "blue";
        }
        if(mapKey.isEmpty()){
            mapKey = "black";
        }

        return colors.get(mapKey);
    }

    private static int findMax(int nr1, int nr2, int nr3){
        if(nr1 > nr2){
            return nr1 > nr3 ? nr1 : nr3;
        }
        return nr2 > nr3 ? nr2 : nr3;
    }
}
