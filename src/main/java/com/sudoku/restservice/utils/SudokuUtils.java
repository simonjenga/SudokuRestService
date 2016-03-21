package com.sudoku.restservice.utils;

import org.springframework.stereotype.Component;

/**
 * This class contains miscellaneous utility methods used within the Sudoku rest service project.
 *
 * @author Simon Njenga
 * @since 0.1
 */
@Component("sudokuUtils")
public class SudokuUtils {

    /**
     * Check if the input parameter contains only digit characters.
     */
    public boolean isDigit(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (Character.isDigit(characters[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert the input parameter to an integer value.
     */
    public Integer toInteger(String param) {
        return Integer.valueOf(param);
    }
}
