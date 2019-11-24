package org.leonardi.bugreport;

import java.util.ArrayList;
import java.util.Scanner;

class Database {

        private ArrayList<AbstractBug> bugs = new ArrayList<>();

        public void addBug(AbstractBug bug){
            bugs.add(bug);
        }

        public AbstractBug searchBug(Integer bugID){

            for (int i = 0; i<bugs.size(); i++){
                if (bugs.get(i).getBugID() == bugID) {
                    return bugs.get(i);
                }else {
                    i++;
                }
            }
            return null;
        }

        //this is used when modifying the entries of a bug
        public void replaceBug(Integer bugID, AbstractBug bug){
            for (int i = 0; i<bugs.size(); i++){
                if (bugs.get(i).getBugID() == bugID) {
                    bugs.remove(i);
                    bugs.add(bug);
                }else {
                    i++;
                }
            }
        }

        public void deleteBug(Integer bugID){
            for (int i = 0; i<bugs.size(); i++){
                if (bugs.get(i).getBugID() == bugID) {
                    bugs.remove(i);
                }else {
                    i++;
                }
            }
        }

        public static int askForABug(){
            System.out.println("Enter a bug number.");
            Scanner userInput = new Scanner(System.in);
            return userInput.nextInt();
        }








//        private Map <Integer, AbstractBug> bugs;
//
//        public void addBug(Integer bugID, AbstractBug bug){
//            bugs.put(1, bug);
//        }
//
//        public AbstractBug searchBugByID(Integer bugID){
//
//            for (Map.Entry<Integer, AbstractBug> entry : bugs.entrySet()) {
//                AbstractBug bugFound = entry.getValue();
//            }
//
//        }





}
