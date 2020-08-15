/*
 * #%L
 * Advanced Java LIVE course-2020
 * %%
 * Copyright (C) 2020 MasterDevSkills.com
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package com.masterdevskills.cha1.ext1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * TODO : Write a file processor that would read text from a text file.
 * Discard the empty line
 * Log the count of the lines of the file
 * Write in another file
 */

public class FileProcessor {

    /**
     * Add your code in the following method
     * This method is supposed to read text from given file
     * and return the all the lines as a List of string
     *
     * @param fileName the filename
     *                 <p>
     *                 hints:
     * @see List#removeIf(Predicate)
     */

    public static List<String> readFileFrom(String fileName) {
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null ) {
                if (line.length() > 0) stringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


    public static void main(String[] args) {
        writeToFile(Arrays.asList("apple", "ordewdewange") , "/home/tanvir/Documents/assighnments/assighnmenmts1/advancejava-exercise/src/main/java/com/masterdevskills/cha1/ext1/ok.txt");
    }
    public static void writeToFile(List<String> lines, String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            lines.forEach(s -> {
                        try {
                            bufferedWriter.write(s + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

