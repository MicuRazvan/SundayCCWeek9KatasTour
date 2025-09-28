import java.util.Arrays;

//https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1
//Counting Duplicates
/*
Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class Kyu6 {
    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        char[] sortedText = text.toCharArray();
        Arrays.sort(sortedText);

        int currentRepeats;
        int nrOfRepeatedChars = 0;
        int i = 0;
        while(i < sortedText.length){
            int j = i + 1;
            currentRepeats = 1;
            while(j < sortedText.length && sortedText[j] == sortedText[i]){
                currentRepeats++;
                j++;
            }
            if(currentRepeats > 1){
                nrOfRepeatedChars++;
            }
            i = j;
        }
        return nrOfRepeatedChars;
    }
}
