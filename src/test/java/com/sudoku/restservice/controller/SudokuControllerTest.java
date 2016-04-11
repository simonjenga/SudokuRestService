package com.sudoku.restservice.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sudoku.restservice.constants.SudokuStatus;

/**
 * Test case for {@link SudokuController}.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class, inheritListeners = true)
public class SudokuControllerTest {
	
	@Autowired
	private SudokuController sudokuController;
	
	private MockMvc mockMvc;
	
	@Before
    public void setUp() throws Exception {
    	this.mockMvc = MockMvcBuilders.standaloneSetup(this.sudokuController).build();
    }
}