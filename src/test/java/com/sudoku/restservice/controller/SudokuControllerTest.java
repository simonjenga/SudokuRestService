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
}
