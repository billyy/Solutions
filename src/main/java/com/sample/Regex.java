package com.sample;

public class Regex {
  //Back tracking will use stack. 
  //DP will require memoization (Map to store the previous computed value.
    public boolean isMatch(String s, String p) {

        if (s.length() == 0 || p.length() == 0) 
            return false;

        boolean match = true;
        int snx = 0, pnx = 0;
        char giveBack = 0;
        
        while (snx <= s.length() - 1 && pnx <= p.length() - 1) {	
	        char b = 0;	
	        boolean zeroOrMore = false;
	        boolean matchAny = false;
	        giveBack = 0;
	        
	        //Determine the rule (what character, match one, exact match or zero/more)	
	        if (pnx <= p.length() -1) {	
		        b = p.charAt(pnx);		
	        	//Match any character
		        if (b == '.') matchAny = true;

		        //Need to check if the following matching character is "*"
		        if ((pnx != p.length() -1) && p.charAt(pnx + 1) == '*') {		
			        zeroOrMore = true;			
			        pnx++;		
		        }		        
		        pnx++;

	        } 
       	
	        if (zeroOrMore) {
		        while(snx <= s.length() - 1) {
		        	char a = s.charAt(snx);
		        	if (a == b || matchAny)  {
		        		giveBack = a;
		        		snx++;
		        	} else 
		        		break;
		        }
	        } else {
	         	char a = s.charAt(snx);               	
		        if (a == b || matchAny)
		        	snx++;
		        else
		        	break;
	        }
        }        

        //If regex is finished and there are still characters, it is only partial match.
        	if (snx <= s.length() - 1 || pnx <= p.length() -1)  
        		match = false;
        	//Cannot tell the difference between end of p or at the last character.  That's the bug.
            if ((giveBack != 0 && s.charAt(snx - 1) == giveBack))
                	match = true;             

        return match;
    }




}