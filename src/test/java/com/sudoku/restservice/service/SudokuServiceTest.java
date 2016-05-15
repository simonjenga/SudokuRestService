package com.sudoku.restservice.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.sudoku.restservice.constants.SudokuGrid;
import com.sudoku.restservice.constants.SudokuStatus;

/**
 * Test case for {@link SudokuService}.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class, inheritListeners = true)
public class SudokuServiceTest {

    @Autowired
    private SudokuService sudokuService;

    /**
     * This test should testInsertValidMoveIn3x3Cell.
     * 
     * @throws Exception If something goes wrong
     */
    @Test
    public void testInsertValidMoveIn3x3Cell() throws Exception {
        final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;

        // insert valid value at first 3x3 cell
        Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(0, 0, 7, SudokuGrid.GRID_PROD));
        Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(0, 1, 9, SudokuGrid.GRID_PROD));

        // insert valid value at middle 3x3 cell
        Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(3, 3, 8, SudokuGrid.GRID_PROD));
        Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(5, 5, 3, SudokuGrid.GRID_PROD));

        // insert valid value at last 3x3 cell
        Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(8, 8, 3, SudokuGrid.GRID_PROD));
        Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(6, 6, 6, SudokuGrid.GRID_PROD));
    }
	
	/**
     * This test should testInsertValidMoveInRow.
     * 
     * @throws Exception If something goes wrong
     */
	@Test
	public void testInsertValidMoveInRow() throws Exception {
		final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
		
		// insert valid value at first row, fourth column
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(0, 3, 6, SudokuGrid.GRID_PROD));
		
		// insert valid value at sixth row, ninth column
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(5, 8, 4, SudokuGrid.GRID_PROD));
	}
	
	/**
     * This test should testInsertValidMoveInColumn.
     * 
     * @throws Exception If something goes wrong
     */
	@Test
	public void testInsertValidMoveInColumn() throws Exception {
		final String result = SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
		
		// insert valid value at second column, fifth row
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(4, 1, 6, SudokuGrid.GRID_PROD));
		
		// insert valid value at fifth column, seventh row
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(6, 4, 3, SudokuGrid.GRID_PROD));
	}
	
	/**
     * This test should testInsertInValidMoveIn3x3Cell.
     * 
     * @throws Exception If something goes wrong
     */
	@Test
	public void testInsertInValidMoveIn3x3Cell() throws Exception {
		final String result = SudokuStatus.INVALID_MOVE_SUDOKU_NOT_COMPLETE;
		
		// insert invalid value at first 3x3 cell
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(0, 1, 5, SudokuGrid.GRID_PROD));
		
		// insert invalid value at middle 3x3 cell
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(4, 3, 2, SudokuGrid.GRID_PROD));
		
		// insert invalid value at last 3x3 cell
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(7, 7, 5, SudokuGrid.GRID_PROD));
	}
	
	/**
     * This test should testInsertInValidMoveInRow.
     * 
     * @throws Exception If something goes wrong
     */
	@Test
	public void testInsertInValidMoveInRow() throws Exception {
		final String result = SudokuStatus.INVALID_MOVE_SUDOKU_NOT_COMPLETE;
		
		// insert invalid value at second row, second column
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(1, 1, 8, SudokuGrid.GRID_PROD));
	}
	
	/**
     * This test should testInsertInValidMoveInColumn.
     * 
     * @throws Exception If something goes wrong
     */
	@Test
	public void testInsertInValidMoveInColumn() throws Exception {
		final String result = SudokuStatus.INVALID_MOVE_SUDOKU_NOT_COMPLETE;
		
		// insert invalid value at fith column, fifth row
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(4, 4, 6, SudokuGrid.GRID_PROD));
	}
	
	/**
     * This test should testInsertInValidInputInSudoku.
     * 
     * @throws Exception If something goes wrong
     */
	@Test
	public void testInsertInValidInputInSudoku() throws Exception {
		final String result = SudokuStatus.INVALID_INPUT;
		
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(9, 9, 10, SudokuGrid.GRID_PROD));
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(-1, -1, -1, SudokuGrid.GRID_PROD));
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(10, -2, 15, SudokuGrid.GRID_PROD));
	}
	
	/**
     * This test should testInsertValidInputAndCompleteSudoku.
     * 
     * @throws Exception If something goes wrong
     */
	@Test
	public void testInsertValidInputAndCompleteSudoku() throws Exception {
		final String result = SudokuStatus.VALID_MOVE_SUDOKU_COMPLETE;
		
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(0, 0, 7, SudokuGrid.GRID_TEST));
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(8, 8, 7, SudokuGrid.GRID_TEST));
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(0, 8, 8, SudokuGrid.GRID_TEST));
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(8, 0, 6, SudokuGrid.GRID_TEST));
		Assert.assertEquals(result, this.sudokuService.insertValuesOnSudokuPuzzle(4, 4, 1, SudokuGrid.GRID_TEST));
	}
	
	@After
    public void tearDown() throws Exception {
        // Intentionally empty!
    }
}
