/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author tien_do
 */
public class validation {
     private final static Scanner in = new Scanner(System.in);

    public static String check_input_string(String MSG) {
        //loop until user input correct
        String input = " ";
        do {
            System.out.println(MSG);
            input = in.nextLine().trim();
            if (!input.matches("[\\w\\s]+")) {
                System.out.println("Not right.Please enter again !!!");
            } else {
                return input;
            }

        } while (true);
    }

    public static int check_input_int(String MSG, int min, int max) {
        int num;
        String input;
        do {
            System.out.println(MSG);
            input = in.nextLine().trim();
            if (input.matches("\\d+")) {
                num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.println("Please enter from" + min +"to" + max);
                    continue;
                }
            }

        } while (true);
        return num;
    }

    public static double check_input_double(String MSG, double min, double max) {
        double num;
        String input;
        do {
            System.out.println(MSG);
            input = in.nextLine().trim();
            try {
                num = Double.parseDouble(input);
                if (num >= min && num <= max) {
                     break;
                }
            } catch (Exception e) {
                    System.out.println("Please enter from" + min +"to" + max);
                continue;
            }
        } while (true);

        return num;
    }

    public static boolean check_input_YN(String MSG) {
        do {
            String input = check_input_string(MSG);
            if (input.matches("[yY]")) {
                return true;
            }
            if (input.matches("[nN]")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        } while (true);
    }

    //check experience must be smaller then age
    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = check_input_int("Enter year of experience: ", 1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }
    
    //check user input graduation rank
    public static String checkInputGraduationRank() {
        while (true) {
            String result = check_input_string("Enter graduation rank: ");
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }
    
    private static final String PHONE_VALID = "^\\d{10}\\d*$";
    //check phone is number with minimum 10 characters
    public static String checkInputPhone() {
        while (true) {
            String result = check_input_string("Enter phone: ");
            //check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    private static final String EMAIL_VALID
            = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    //check email with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
    public static String checkInputEmail() {
        //loop until user input correct
        while (true) {
            String result = check_input_string("Enter email: ");
            //check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

     //check id exist or not
    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }
    
}
