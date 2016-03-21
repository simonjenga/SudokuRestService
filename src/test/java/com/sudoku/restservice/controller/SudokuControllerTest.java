package com.sudoku.restservice.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.client.RestTemplate;

import com.sudoku.restservice.constants.SudokuStatus;

/**
 * Test case for {@link SudokuController}.
 * 
 * This test class is disabled by default as it requires the web service to be deployed and be running
 * on the Server before any of these test(s) can be executed.
 * 
 * In order to make this test class to work, deploy the web service on the server and ensure it is running
 * and then comment out (uncomment) the first annotation {@link org.junit.Ignore} in this class.
 * 
 * Otherwise, the test class throws the following error message: 
 * I/O error: Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@org.junit.Ignore
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class, inheritListeners = true)
public class SudokuControllerTest {
	
	@Autowired
	private SudokuController sudokuController;
	
	private String baseURL;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.baseURL = "http://localhost:8080/SudokuRestService/sudokuservice/sudoku";
        this.template = new RestTemplate();
    }
    
    /**
     * This test should testControllerInsertValidMoveIn3x3Cell.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
	public void testControllerInsertValidMoveIn3x3Cell() throws Exception {
    	final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
    	
        ResponseEntity<String> response1 = this.template.getForEntity(this.baseURL.concat("?row=0&column=0&value=7"), String.class);
        ResponseEntity<String> response2 = this.sudokuController.validateMovesOnSudoku("0", "0", "7");
        
        Assert.assertTrue(response1 != null && response1.hasBody() && !response1.getBody().isEmpty());
        Assert.assertTrue(response2 != null && response2.hasBody() && !response2.getBody().isEmpty());
        
        Assert.assertEquals(result, response1.getBody());
        Assert.assertEquals(result, response2.getBody());
    }
    
    /**
     * This test should testControllerInsertValidMoveInRow.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
	public void testControllerInsertValidMoveInRow() throws Exception {
    	final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
    	
    	ResponseEntity<String> response1 = this.template.getForEntity(this.baseURL.concat("?row=5&column=8&value=4"), String.class);
        ResponseEntity<String> response2 = this.sudokuController.validateMovesOnSudoku("5", "8", "4");
        
        Assert.assertTrue(response1 != null && response1.hasBody() && !response1.getBody().isEmpty());
        Assert.assertTrue(response2 != null && response2.hasBody() && !response2.getBody().isEmpty());
        
        Assert.assertEquals(result, response1.getBody());
        Assert.assertEquals(result, response2.getBody());
    }
    
    /**
     * This test should testControllerInsertValidMoveInColumn.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
	public void testControllerInsertValidMoveInColumn() throws Exception {
    	final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
    	
    	ResponseEntity<String> response1 = this.template.getForEntity(this.baseURL.concat("?row=6&column=4&value=3"), String.class);
        ResponseEntity<String> response2 = this.sudokuController.validateMovesOnSudoku("6", "4", "3");
        
        Assert.assertTrue(response1 != null && response1.hasBody() && !response1.getBody().isEmpty());
        Assert.assertTrue(response2 != null && response2.hasBody() && !response2.getBody().isEmpty());
        
        Assert.assertEquals(result, response1.getBody());
        Assert.assertEquals(result, response2.getBody());
    }
    
    /**
     * This test should testControllerInsertInValidMoveIn3x3Cell.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
	public void testControllerInsertInValidMoveIn3x3Cell() throws Exception {
    	final String result = SudokuStatus.INVALID_MOVE_SUDOKU_NOT_COMPLETE;
    	
    	ResponseEntity<String> response1 = this.template.getForEntity(this.baseURL.concat("?row=7&column=7&value=5"), String.class);
        ResponseEntity<String> response2 = this.sudokuController.validateMovesOnSudoku("7", "7", "5");
        
        Assert.assertTrue(response1 != null && response1.hasBody() && !response1.getBody().isEmpty());
        Assert.assertTrue(response2 != null && response2.hasBody() && !response2.getBody().isEmpty());
        
        Assert.assertEquals(result, response1.getBody());
        Assert.assertEquals(result, response2.getBody());
    }
}
