package com.example.project.WordScramble;
import java.util.ArrayList;
public class WordScramble {
  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
      String newWord = "";
      for (int c = 0; c < word.length() - 1; c ++) {
        if (word.substring(c, c + 1).equals("A") && !word.substring(c + 1, c + 2).equals("A")) {
          newWord += word.substring(c + 1, c + 2) + word.substring(c, c + 1);
          c ++;
        } else {
          newWord += word.substring(c, c + 1);
        }
        if (c == word.length() - 2) {
          newWord += word.substring(c + 1, c + 2);
        }
      }
      if (word.length() == 1) {
        newWord = word;
      }
      return newWord;
  }

  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
    ArrayList<String> s = new ArrayList<String>();
    for (String c : wordList) {
      if (!c.equals(scrambleWord(c))) {
        s.add(scrambleWord(c));
        System.out.println(s);
      }
    }
    wordList = s;
    return wordList;
  }
}
