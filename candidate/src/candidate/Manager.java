/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author tien_do
 */
public class Manager {
    //display menu
    public  int menu() {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        int choice = validation.check_input_int("Enter your choice: ", 1, 5);
        return choice;
    }
    
     //allow user input information common of candidate
    public  void createCandidate(ArrayList<Candidate> candidates,
            int type) {
        //loop until user don't want to create new candidate
        while (true) {
            String id = validation.check_input_string("Enter id: ");
            String firstName = validation.check_input_string("Enter first name: ");   
            String lastName = validation.check_input_string("Enter last name: ");
            int birthDate = validation.check_input_int("Enter birth date: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            String address = validation.check_input_string("Enter last name: ");
            String phone = validation.checkInputPhone();
            String email = validation.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);
            //check id exist or not
            if (validation.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }            //check user want to create new candidate or not
            if (!validation.check_input_YN("Do you want to continue (Y/N): ")) {
                return;
            }
        }
    }

    //allow user create experience
    public  void createExperience(ArrayList<Candidate> candidates,
            Candidate candidate) {
        int yearExperience = validation.checkInputExprience(candidate.getBirthDate());
        String professionalSkill = validation.check_input_string("Enter professional skill: ");
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create fresher
    public  void createFresher(ArrayList<Candidate> candidates,
            Candidate candidate) {
        String graduationDate = validation.check_input_string("Enter graduation date: ");
        String graduationRank = validation.checkInputGraduationRank();
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create internship
    public  void createInternship(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter major: ");
        String major = validation.check_input_string("Enter major: ");
        String semester = validation.check_input_string("Enter semester: ");
        String university = validation.check_input_string("Enter university: ");
        candidates.add(new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user search candidate by name
    public  void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        String nameSearch = validation.check_input_string("Enter andidate name (First name or Last name): ");
        int typeCandidate = validation.check_input_int("Enter type of candidate: ", 0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

    //display list name candidate
    public  void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.out.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
}
