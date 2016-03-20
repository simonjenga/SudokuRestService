package com.sudoku.restservice.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sudoku.restservice.constants.SudokuGrid;
import com.sudoku.restservice.service.SudokuService;

/**
 * This class is the Sudoku controller class used to process HTTP requests and responses to the
 * Sudoku rest service.
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Controller
public class SudokuController {

	@Resource
	private SudokuService sudokuService;
	
	@RequestMapping(value = "/sudoku/{row}/{column}/{value}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> validateMovesOnSudoku(@PathVariable("row") Integer row, @PathVariable("column") Integer column,
			@PathVariable("value") Integer value) {
		String feedback = sudokuService.insertValuesOnSudokuPuzzle(row, column, value, SudokuGrid.GRID_PROD);
		
		if (feedback == null || feedback.isEmpty()) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
        	return new ResponseEntity<String>(feedback, HttpStatus.OK);
        }
	}
}
