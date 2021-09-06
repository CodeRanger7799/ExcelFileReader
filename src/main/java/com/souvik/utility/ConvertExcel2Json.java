package com.souvik.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.souvik.model.Student;
import com.souvik.model.Subjects;
import com.souvik.model.SubjectsDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertExcel2Json {

    public static void main(String[] args) {
        List<Student> student = populateStudents("Student.xlsx");
        List<SubjectsDto> subjectsDto = populateSubjectDto("Student.xlsx");
        student = fillSubjectIntoStudent(student,subjectsDto);
        student.stream().forEach(System.out::println);
    }


    private static List<Student> populateStudents(String filePath){
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            List<Student> listStudent = new ArrayList();
            Sheet sheet = workbook.getSheet("Students");
            if(sheet != null){
                Iterator rows = sheet.iterator();
                int rowNumber = 0;
                while (rows.hasNext()) {
                    Row currentRow = (Row) rows.next();

                    if(rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }

                    Iterator cellsInRow = currentRow.iterator();

                    Student student = new Student();

                    int cellIndex = 0;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = (Cell) cellsInRow.next();

                        if(cellIndex==0) { // RollNumber
                            student.setRollNumber(String.valueOf((int)currentCell.getNumericCellValue()));
                        } else if(cellIndex==1) { // Name
                            student.setName(currentCell.getStringCellValue());
                        } else if(cellIndex==2) { // Class
                            student.setLevel(String.valueOf((int)currentCell.getNumericCellValue()));
                        } else if(cellIndex==3) { // Section
                            student.setSection(currentCell.getStringCellValue());
                        }

                        cellIndex++;
                    }

                    listStudent.add(student);
                }

            }
            workbook.close();
            return listStudent;
        } catch (IOException e) {
            throw new RuntimeException("Exception= " + e.getMessage());
        }
    }

    private static List<SubjectsDto> populateSubjectDto(String filePath){
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            List<SubjectsDto> listSubjects = new ArrayList();
            Sheet sheet = workbook.getSheet("Subjects");
            if(sheet != null){
                Iterator rows = sheet.iterator();
                int rowNumber = 0;
                while (rows.hasNext()) {
                    Row currentRow = (Row) rows.next();

                    if(rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }

                    Iterator cellsInRow = currentRow.iterator();

                    SubjectsDto subjectsDto = new SubjectsDto();

                    int cellIndex = 0;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = (Cell) cellsInRow.next();

                        if(cellIndex==0) { // RollNumber
                            subjectsDto.setRollNumber(String.valueOf((int)currentCell.getNumericCellValue()));
                        } else if(cellIndex==1) { // Subject Name
                            subjectsDto.setName(currentCell.getStringCellValue());
                        } else if(cellIndex==2) { // Mark
                           subjectsDto.setMark((int) currentCell.getNumericCellValue());
                        }
                        cellIndex++;
                    }

                    listSubjects.add(subjectsDto);
                }

            }


            workbook.close();

            return listSubjects;
        } catch (IOException e) {
            throw new RuntimeException("Exception= " + e.getMessage());
        }
    }

    public static List<Student> fillSubjectIntoStudent(List<Student> students,List<SubjectsDto> subjectsDto){
        students.stream().forEach(each -> {
            each.setSubjects(subjectsDto.stream().filter(eachSubject -> eachSubject.getRollNumber().equals(each.getRollNumber()))
                    .map(eachSubject -> new Subjects(eachSubject.getName(),eachSubject.getMark())).collect(Collectors.toList()));
        });
        return students;
    }
}
