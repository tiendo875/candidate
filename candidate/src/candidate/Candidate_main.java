/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;

/**
 *
 * @author tien_do
 */
public class Candidate_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Candidate> arr = new ArrayList<>();
        Manager Mg = new Manager();
        do {
            int choice = Mg.menu();
            switch (choice) {
                case 1:
                    Mg.createCandidate(arr, 0);
                    break;
                case 2:
                    Mg.createCandidate(arr, 1);
                    break;
                case 3:
                    Mg.createCandidate(arr, 2);
                    break;
                case 4:
                    Mg.searchCandidate(arr);
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
    
}
