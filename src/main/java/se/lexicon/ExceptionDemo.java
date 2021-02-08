package se.lexicon;

import se.lexicon.exceptions.FileFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {
        //ex3();
        /*
        try {
            readFile("E:\\mproject\\g34_exception_lecture\\player.txt");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


        try {
            dbConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

        readFileNew();

    }

    public static void ex1() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a Number: ");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                System.out.println("Result : " + number * number);
            } catch (NumberFormatException e) {
                System.out.println("#### Number is not valid ####");
            }
        }
    }

    public static void ex2() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            try {
                System.out.println(name.charAt(5));
            } catch (StringIndexOutOfBoundsException e) {
                //e.printStackTrace();
                System.out.println("#### Error: " + e.getMessage());
            }
        }
    }

    public static void ex3() {
        int[] numbers = {1, 2, 7, 9};
        try {
            System.out.println(numbers[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void ex4() {
        String fileName = "E:\\mproject\\g34_exception_lecture\\player.txt";
        File file = new File(fileName);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            inputStream.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readFile(String fileName) throws IOException {
        if (fileName.contains(".txt")){
            throw new FileFormatException("file type is not valid");
        }
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        int x = 0;
        while ((x = inputStream.read()) != -1) {
            System.out.print((char) x);
        }
    }

    public static void dbConnection() throws SQLException {

    }

    public static void readFileNew(){
        File file = new File("E:\\mproject\\g34_exception_lecture\\player.txt");
        FileInputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);
            int x = 0;
            while ((x = inputStream.read()) != -1) {
                System.out.print((char) x);
            }
            System.out.println("\n\n");
        }catch (IOException e){
            System.out.println("IOError: "+e.getMessage());
        } finally {
            try {
                if (inputStream != null) inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("#### finally block #### ");
        }
    }

    public static int getNumber(){
        Scanner scanner= new Scanner(System.in);
        int number = 0;
        int result = 0;
        try{
            System.out.println("Enter a number:");
            number = scanner.nextInt();
            result = number * 2;
            System.out.println("number = " + result);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            scanner.close();
            result = 0;
        }
        return number;
    }

    public static void readFileTryWithResources(){
        File file = new File("E:\\mproject\\g34_exception_lecture\\player.txt");
        try(
                FileInputStream inputStream = new FileInputStream(file);
                FileInputStream inputStream2 = new FileInputStream(file);
                ) {

            int x = 0;
            while ((x = inputStream.read()) != -1) {
                System.out.print((char) x);
            }
            System.out.println("\n\n");
        }catch (IOException e){
            System.out.println("IOError: "+e.getMessage());
        }
    }


}
