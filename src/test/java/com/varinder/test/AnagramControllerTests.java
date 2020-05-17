package com.varinder.test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.varinder.controller.AnagramController;
import com.varinder.service.AnagramService;

@RunWith(SpringRunner.class)
@WebMvcTest(AnagramController.class)
public class AnagramControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AnagramService service;

	@Test
	public void generateAnagramsTest() {
		List<String> result = Arrays.asList("abc", "acb", "bca", "bac", "cab", "cba");
		Mockito.when(service.generateAnagrams(anyString())).thenReturn(result);

		try {
			mvc.perform(get("/anagrams/abc").contentType("application/json")).andExpect(status().isOk())
					.andExpect(jsonPath("$.anagrams.length()", is(6)));

			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void compareAnagramsTest() {
		Mockito.when(service.checkAnagrams(anyString(), anyString())).thenReturn(false);
		try {
			mvc.perform(get("/anagrams/abc/cob").content("application/json"))
					.andExpect(jsonPath("$.areAnagrams", is(false)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
