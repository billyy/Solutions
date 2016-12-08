package com.sample;


public class Regex {
    public boolean isMatch(String s, String regex) {
        for (int i = 0; i <= s.length(); ++i) {
            if (isMatchHere(regex, s.substring(i))) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isMatchHere(String regex, String s) {
        if (regex.isEmpty()) 
            return true;
            
        if (regex.length() >= 2 && regex.charAt(1) == '*') {
            for(int i = 0; i < s.length()  &&  (regex.charAt(0) == '.'); ++i) {
                if (isMatchHere(regex.substring(2), s.substring(i + 1))) {
                    return true;
                }
            }
            
            //See '*' matches zero character in s.
            return isMatchHere(regex.substring(2), s);

        }
        
        // regex begins with single character match
        return !s.isEmpty() && (regex.charAt(0) == '.' || regex.charAt(0) == s.charAt(0)) 
                && isMatchHere(regex.substring(1), s.substring(1));
        
    }
}