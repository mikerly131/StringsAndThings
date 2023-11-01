package io.zipcoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        // break string into words, split by space, escape space character
        int counter = 0;
        String[] words = input.split("\\s+");

        // loop through words, if word ends in y or z, count + 1
        for (int i = 0; i < words.length; i++){
            // char lastCharacter = words[i].charAt(words[i].length() - 1);
            if (words[i].endsWith("y")|| words[i].endsWith("z")) {
                counter++;
            }
        }
        // return count
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return base.replace(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {

        /*  After many failed tries with loops looking at index values, I found a string size comparison example on google.
        *   Tam and Louie both got their loops to work, Louie was checking sets of characters and looping
        *   Louie and I debugged my loop for half an hour together, wanting to see if we could make checking index work...we didn't
        *   This solution is an obvious one....after seeing it of course
        *
        int isCount = (input.length() - input.replace("is", "").length()) / 2;
        int notCount = (input.length() - input.replace("not", "").length()) / 3;
        System.out.println("Is: " + isCount);
        System.out.println("Not: " + notCount);
        return (isCount == notCount);
        */


        /* Not working yet Idea:  Find index value of first occurrence of <substring>, count, then move to next.
         Loop through the input starting at index 0 of input
         Iterate for each index position until none left
         If the string <substring> starts at the position, add +1 to <substring> counter
         compare <substring> counts, return true if equal otherwise false

         Notes:
         Tried 2 for loops, one for each substring so I wasn't overwriting same variables...
         but what variables, well if i checked every position of string for some reason the count was wrong...
         so using a variable to move the next position to check past the end of the substring was the idea...
         and it didn't work well at all, the counts got even less understandable.
         */

        // Try number 134234...I figured it out, I need to check if I make it to the end of the string
        // In that case I get -1 back and I need stop.

        int[] subStringCounter = {0, 0};
        String[] subStrs = {"is", "not"};

        // Loop: Check each substring....
        for (int j = 0; j < subStrs.length; j++) {

            int indexLocation = 0;
            int subStringLocation = 0;
            // Loop: 1. Start at position I (0) in the input string, max loops is 17
            //       5. Increment I so it points to next indexLocation 4, (4)
            //       6. If I is less than max loops, do 1 again,  4 < 11, do again
            //       7. Increment I, 4 + ?  = (7 + 2)...subStringLocation
            //       input "This is notnot"
            //       "noisxxnotyynotxisi"
            for (int i = 0; i < input.length(); i = i + indexLocation) {

                // 2. Set subStringLocation to first index location it is found in string  (6)  (5)
                subStringLocation = input.indexOf(subStrs[j], indexLocation);

                if (subStringLocation == -1) {
                    break;
                } else {
                    // 3. Set the next index location to check to be after the subString  (2 + 2) = 4  (5 + 2) = 7
                    indexLocation = subStringLocation + subStrs[j].length();
                    // 4. Increment the subString counter  (+1 = 1)  (+1 = 2)
                    subStringCounter[j]++;
                }

            }
        }

        return (subStringCounter[0] == subStringCounter[1]);
    }
    

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return true
     */
    //public Boolean gIsHappy(String input){
    //    return null;
    //}


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    // public Integer countTriple(String input){
    //     return null;
    // }
}
