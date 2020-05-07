package com.sudoku.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sudoku.restservice.constants.SudokuGrid;
import com.sudoku.restservice.constants.SudokuStatus;
import com.sudoku.restservice.service.SudokuService;
import com.sudoku.restservice.utils.SudokuUtils;

/**
 * This class {@code SudokuController} is used to process HTTP requests and responses to the
 * service class {@code SudokuService} in this project.
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Controller
public class SudokuController {

    @Autowired
    private SudokuService sudokuService;

    @Autowired
    private SudokuUtils sudokuUtils;

    @RequestMapping(value = "/sudoku", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> validateMovesOnSudoku(@RequestParam(value = "row", required = true) String row,
        @RequestParam(value = "column", required = true) String column,
        @RequestParam(value = "value", required = true) String value) {

        if ((row == null || row.isEmpty()) || (column == null || column.isEmpty()) || (value == null || value.isEmpty())) {
            return new ResponseEntity<String>(SudokuStatus.ONLY_THREE_PARAMETERS_ARE_ALLOWED, HttpStatus.NOT_FOUND);
        } else {
            if(sudokuUtils.isDigit(row) && sudokuUtils.isDigit(column) && sudokuUtils.isDigit(value)) {
                return new ResponseEntity<String>(this.responseFeedBack(row, column, value), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>(SudokuStatus.ONLY_NUMBER_PARAMETERS_ARE_ALLOWED, HttpStatus.NOT_FOUND);
            }
        }
    }

    /**
     * Insert values on the Sudoku puzzle and obtain the result
     */
    private String responseFeedBack(String row, String column, String value) {
        return sudokuService.insertValuesOnSudokuPuzzle(
            sudokuUtils.toInteger(row), sudokuUtils.toInteger(column), sudokuUtils.toInteger(value), SudokuGrid.GRID_PROD
        );
    }
}
