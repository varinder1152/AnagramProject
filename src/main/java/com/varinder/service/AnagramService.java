package com.varinder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class AnagramService {
	
	/**
	 * A compare method which accepts 2 string arguments to compare 
	 * the anagrams
	 * @param 
	 * @param 
	 * @return Boolean
	 * 
	 * 
	 */
public boolean checkAnagrams(String firstStr, String secondStr) {
		
		if(firstStr.length()!=secondStr.length())
			return false;

		Map<Character, Long> lettersInWord1 = new HashMap<Character, Long>();
		lettersInWord1 = firstStr.trim().chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		char[] word2 = secondStr.trim().toCharArray();
		for (char c : word2) {
			long count = -1;
			if (lettersInWord1.containsKey(c)) {
				count = lettersInWord1.get(c) - 1;
			}
			lettersInWord1.put(c, count);
		}

		for (char c : lettersInWord1.keySet()) {
			if (lettersInWord1.get(c) != 0) {
				return false;
			}
		}

		return true;
	}


/**
 * A generate method which accepts  string argument to generate the anagrams
 * @param  
 * @return List<String>
 * 
 * 
 */
public List<String> generateAnagrams(String input)
{
	
	List<String> set = new ArrayList<String>();
	    if (input == "")
	        return set;

	    Character a = input.charAt(0);

	    if (input.length() > 1)
	    {
	        input = input.substring(1);

	        List<String> permSet = generateAnagrams(input);

	        for (String x : permSet)
	        {
	            for (int i = 0; i <= x.length(); i++)
	            {
	                set.add(x.substring(0, i) + a + x.substring(i));
	            }
	        }
	    }
	    else
	    {
	        set.add(a + "");
	    }
	    return set;
	}
}

