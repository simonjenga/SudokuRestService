package com.sudoku.restservice.service;

import org.springframework.stereotype.Service;

import com.sudoku.restservice.constants.SudokuStatus;

/**
 * This class is the Sudoku service class that contains the logic to the Sudoku
 * puzzle.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@Service("sudokuService")
public class SudokuService {

    /**
     *  Insert values on Sudoku puzzle
     */
	public String insertValuesOnSudokuPuzzle(int row, int column, int value,
			int[][] grid) {
		if ((row < 0 || row > 8) || (column < 0 || column > 8) || (value < 1 || value > 9)) {
		    return SudokuStatus.INVALID_INPUT;
		} else {
		    if (this.validateMovesOnSudokuPuzzle(row, column, value, grid).equals(SudokuStatus.VALID_MOVE)) {
			    grid[row][column] = value;
			    // if there are empty/free cells, the Sudoku is still not yet complete!
			    if (this.getFreeCellList(grid) > 0) {
				    return SudokuStatus.VALID_MOVE_SUDOKU_NOT_COMPLETE;
			    } else {
			    	// Sudoku is complete because there are no more empty/free cells
				    return SudokuStatus.VALID_MOVE_SUDOKU_COMPLETE;
			    }	
		    } else {
			    return SudokuStatus.INVALID_MOVE_SUDOKU_NOT_COMPLETE;
		    }
		}
	}

    /**
     *  Validate moves on Sudoku puzzle
     */
	private String validateMovesOnSudokuPuzzle(int row, int column, int value,
			int[][] grid) {
		if (this.isValid(grid, row, column, value)) {
			return SudokuStatus.VALID_MOVE;
		} else {
			return SudokuStatus.INVALID_MOVE;
		}
	}

    /**
     * Obtain a list of free cells from the puzzle
     */
	private int getFreeCellList(int[][] grid) {
		// Determine the number of free cells
		int numberOfFreeCells = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String cellValue = String.valueOf(grid[i][j]);
				if (cellValue == null || cellValue.isEmpty() || cellValue.equals("0")) {
					numberOfFreeCells++;
				}
			}
		}
		 // return a multi-dimensional array of free cells
		return numberOfFreeCells;
	}

    /** 
     * Check whether grid[i][j] is valid in the grid
     */
	private boolean isValid(int[][] grid, int row, int column, int value) {
		// Check whether grid[i][j] is valid at the i's row
		for (int inColumn = 0; inColumn < 9; inColumn++) {
			if (inColumn != column && grid[row][inColumn] == value) {
				// The current value at grid[i][j] is invalid
				return false;
			}
		}

		// Check whether grid[i][j] is valid at the j's column
		for (int inRow = 0; inRow < 9; inRow++) {
			if (inRow != row && grid[inRow][column] == value) {
				// The current value at grid[i][j] is invalid
				return false;
			}
		}

		// Check whether grid[i][j] is valid in the 3 by 3 box
		for (int inRow = (row / 3) * 3; inRow < (row / 3) * 3 + 3; inRow++) {
			for (int inColumn = (column / 3) * 3; inColumn < (column / 3) * 3 + 3; inColumn++) {
				if (inRow != row && inColumn != column
						&& grid[inRow][inColumn] == value) {
					// The current value at grid[i][j] is invalid
					return false;
				}
			}
		}
        // The current value at grid[i][j] is valid
		return true;
	}
}
