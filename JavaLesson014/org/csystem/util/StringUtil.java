/*----------------------------------------------------------------------------------------------------------------------
	StringUtil sınıfı  
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

import static java.lang.Character.*;

public class StringUtil {  
    public static String capitalize(String s)
    {
		if (s.isEmpty())
			return s;
			
		return toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();			
    }
        
    public static int countString(String s1, String s2) 
    {
		int count = 0;
			
		for (int i = -1; (i = s1.indexOf(s2, i + 1)) != -1; ++count)
			;
			
		return count;
    }
    		
    public static String getLetters(String s)
    {
		String str = "";
		int length = s.length();
			
		for (int i = 0; i < length; ++i) {
		    char ch = s.charAt(i);
	
		    if (isLetter(ch))
		    	str += ch;
		}
	
		return str;
    }
	  
    public static String getLongestPalindrome(String s)
    {
		String text = "";
	
		int endIndex = s.length();
			
		while (endIndex != 0) {
		    int beginIndex = 0;
	
		    while (beginIndex != endIndex) {
				String str = s.substring(beginIndex++, endIndex);
		
				if (str.length() > 1 && StringUtil.isPalindrome(str) && str.length() > text.length())
				    text = str;
		    }
	
		    --endIndex;
		}
			
		return text;
    }

    public static String getRandomText(Random r, int n, String alphabet) 
    {
		char [] c = new char[n];
	
		for (int i = 0; i < n; ++i) {
		    char ch = alphabet.charAt(r.nextInt(alphabet.length()));
	
		    if (r.nextBoolean())
				ch = toUpperCase(ch);
	
		    c[i] = ch;
		}
	
		return String.valueOf(c);
    }    

    public static String getRandomTextEN(int n) 
    {
    	return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n) 
    {
    	return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyz");
    }

    public static String getRandomTextTR(int n) 
    {
    	return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n) 
    {
    	return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyz");
    }   
  
    public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char chLeft = toLowerCase(s.charAt(left));
			
			if (!isLetter(chLeft)) {
				++left;
				continue;
			}
			
			char chRight = toLowerCase(s.charAt(right));
			
			if (!isLetter(chRight)) {
				--right;
				continue;
			}
			
			if (chLeft != chRight)
				return false;
			
			++left;
			--right;			
		}
		
		return true;						
	}    
    
    public static boolean isPangram(String text, String alphabet) 
    {
		int length = alphabet.length();
	
		for (int i = 0; i < length; ++i)
		    if (!text.contains(alphabet.charAt(i) + ""))
		    	return false;
	
		return true;
    }

    public static boolean isPangramEN(String text) 
    {
    	return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
    }

    public static boolean isPangramTR(String text) 
    {
    	return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
    }

    public static String padLeft(String s, int length) 
    {
    	return padLeft(s, length, ' ');
    }

    public static String padLeft(String s, int length, char ch) 
    {
		length -= s.length();
	
		if (length <= 0)
		    return s;
	
		return repeat(length, ch) + s;
    }

    public static String padRight(String s, int length) 
    {
    	return padRight(s, length, ' ');
    }

    public static String padRight(String s, int length, char ch) 
    {
		length -= s.length();
	
		if (length <= 0)
		    return s;
	
		return s + repeat(length, ch);
    }
    
    public static String removeWhitespaces(String s) 
    {
		int length = s.length();
		String str = "";
	
		for (int i = 0; i < length; ++i) {
		    char ch = s.charAt(i);
	
		    if (!isWhitespace(ch))
				str += ch;
		}
	
		return str;
    }

    public static String repeat(int n, char ch) 
    {
		char [] c = new char[n];
	
		while (n-- > 0)
		    c[n] = ch;
	
		return String.valueOf(c);
    }

    public static String reverse(String str) 
    {
		char [] c = str.toCharArray();

		ArrayUtil.reverse(c);

		return String.valueOf(c);
    }

    public static String trimLeft(String s) 
    {
		int i;
		int len = s.length();
	
		for (i = 0; i < len && isWhitespace(s.charAt(i)); ++i)
		    ;
	
		return s.substring(i);
    }

    public static String trimRight(String s) 
    {
		int i;
	
		for (i = s.length() - 1; i >= 0 && isWhitespace(s.charAt(i)); --i)
		    ;
	
		return s.substring(0, i + 1);
    }
}
