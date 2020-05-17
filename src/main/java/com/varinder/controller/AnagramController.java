package com.varinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.varinder.Anagram;
import com.varinder.service.AnagramService;

/**
 * A rest controller for the mapping of requests
 */
@RestController
public class AnagramController {

	@Autowired
	AnagramService anagramService;
/**
 * A get Mapping method which accepts 2 string arguments to compare 
 * the anagrams
 * @param String1
 * @param String2
 * @return ResponseEntity
 * 
 */
	
	@GetMapping(value = "/anagrams/{string1}/{string2}")
	public ResponseEntity<Anagram> compareAnagrams(@PathVariable("string1") String arg1,
			@PathVariable("string2") String arg2) {

		if (arg1.matches(".*\\d.*") || arg2.matches(".*\\d.*")) {
			return new ResponseEntity<Anagram>(HttpStatus.BAD_REQUEST);

		}
		Anagram result = new Anagram();
		result.setAreAnagrams(anagramService.checkAnagrams(arg1, arg2));

		return new ResponseEntity<Anagram>(result, HttpStatus.OK);

	}

	
	/**
	 * A get Mapping method which accepts  string argument 
	 * to generate the anagrams
	 * @param 
	 * @return ResponseEntity
	 * 
	 */
	@GetMapping(value = "/anagrams/{string1}")
	public ResponseEntity<Anagram> generateAnagrams(@PathVariable("string1") String arg1) {

		if (arg1.matches(".*\\d.*")) {
			return new ResponseEntity<Anagram>(HttpStatus.BAD_REQUEST);

		}

		Anagram result = new Anagram();
		result.setAnagrams(anagramService.generateAnagrams(arg1));
		return new ResponseEntity<Anagram>(result, HttpStatus.OK);

	}

}
