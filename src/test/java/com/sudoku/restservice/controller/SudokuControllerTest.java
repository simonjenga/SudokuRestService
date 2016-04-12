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
	
	/**
     * This test should testControllerInsertValidMoveIn3x3Cell.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
	public void testControllerInsertValidMoveIn3x3Cell() throws Exception {
    	final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
    	
    	this.mockMvc.perform(MockMvcRequestBuilders.get("/sudoku?row=0&column=0&value=7")
			.contentType(MediaType.TEXT_PLAIN).content("{ }"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"));
    	
        ResponseEntity<String> response = this.sudokuController.validateMovesOnSudoku("0", "0", "7");
        
        Assert.assertTrue(response != null && response.hasBody() && !response.getBody().isEmpty());
        
        Assert.assertEquals(result, response.getBody());
    }
    
    /**
     * This test should testControllerInsertValidMoveInRow.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
	public void testControllerInsertValidMoveInRow() throws Exception {
    	final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
    	
    	this.mockMvc.perform(MockMvcRequestBuilders.get("/sudoku?row=5&column=8&value=4")
			.contentType(MediaType.TEXT_PLAIN).content("{ }"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"));
    	
        ResponseEntity<String> response = this.sudokuController.validateMovesOnSudoku("5", "8", "4");
        
        Assert.assertTrue(response != null && response.hasBody() && !response.getBody().isEmpty());
        
        Assert.assertEquals(result, response.getBody());
    }
}