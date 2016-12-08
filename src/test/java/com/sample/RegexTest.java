package com.sample;


import org.junit.Test;


import org.junit.Assert;

public class RegexTest {
    @Test
    public void testPatterns() {
    	Regex x = new Regex();
    	Assert.assertFalse(x.isMatch("aa", "a"));
    	Assert.assertTrue(x.isMatch("aa", "aa"));
//        Assert.assertFalse(x.isMatch("aaa", "aa"));
    	Assert.assertTrue(x.isMatch("aa", "a*"));    	
    	Assert.assertTrue(x.isMatch("ab", ".*"));

    	Assert.assertTrue(x.isMatch("aab", "c*a*b"));
    	Assert.assertFalse(x.isMatch("ab", ".*c"));
    	Assert.assertTrue(x.isMatch("aaa", "a*a"));
    	Assert.assertFalse(x.isMatch("aaa", "aaaa"));
    	Assert.assertTrue(x.isMatch("aaa", "a*a"));
       	Assert.assertTrue(x.isMatch("a*b*c*d*.*abcd.*", "abcd"));
           	
    	
         	   	
    }
}

