package com.example.project.Delimiter;
import java.util.ArrayList;

public class Delimiters {
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }
    

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> c = new ArrayList<String>();
        for (String s : tokens) {
            if (s == openDel || s == closeDel) {
                c.add(s);
            }
        }
        return c;
    }
    

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters) {
        int c1 = 0;
        int c2 = 0;
        for (String s : delimiters) {
            if (s == openDel) {
                c1 ++;
            }
            if (s == closeDel) {
                c2 ++;
            }
            if (c2 > c1) {
                return false;
            }
        }
        if (c1 != c2) {
            return false;
        }
        return true;
    }
}