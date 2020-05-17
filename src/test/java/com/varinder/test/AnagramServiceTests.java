package com.varinder.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.varinder.service.AnagramService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnagramServiceTests {

	@Autowired
	private AnagramService anagramService;

	@Test
	public void checkAnagramTrueTest() {
		boolean result = anagramService.checkAnagrams("iceman", "cinema");
		assertThat(true).isEqualTo(result);
	}

	@Test
	public void checkAnagramFalseTest() {
		boolean result = anagramService.checkAnagrams("iceman", "cineaa");
		assertThat(false).isEqualTo(result);
	}

	@Test
	public void checkAnagramOneArgumentEmptyTest() {
		boolean result = anagramService.checkAnagrams("iceman", "");
		assertThat(false).isEqualTo(result);
	}

	@Test
	public void generateAnagramTest() {

		List<String> actual = Arrays.asList("abc", "acb", "bca", "bac", "cab", "cba");
		List<String> expected = anagramService.generateAnagrams("abc");

		assertThat(actual.size()).isEqualTo(expected.size());
		assertThat(actual.containsAll(expected));
	}

}
