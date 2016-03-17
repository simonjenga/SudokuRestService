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

	/** Check whether grid[i][j] is valid in the grid */
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
