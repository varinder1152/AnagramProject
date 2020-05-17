package com.varinder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Model class to return the Anagram object to requests
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Anagram {

	/**
	 *  boolean to set/get the result of comparison between two strings
	 * 
	 */
	private Boolean areAnagrams;

	public Boolean getAreAnagrams() {
		return areAnagrams;
	}

	public void setAreAnagrams(Boolean areAnagrams) {
		this.areAnagrams = areAnagrams;
	}

	/**
	 * List of all possible anagrams of any String
	 * 
	 */
	private List<String> anagrams;

	public List<String> getAnagrams() {
		return anagrams;
	}

	public void setAnagrams(List<String> list) {
		this.anagrams = list;
	}

	public Anagram() {

	}
}
