package bugreport_project;

import bugreport_project.model.Audio;
import bugreport_project.model.Code;
import bugreport_project.model.Cosmetic;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Dedicated class for usr input and console output. */

class UserInput {

    /* select the bug type returning String */
    private static String selectBugType() {
        System.out.println("Select between the bug types: Cosmetic, Audio or Code. ");
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    /* using bugType to create the bug on request */
    private static AbstractBug createBug(String bugType) {

        switch (bugType) {
            case "Cosmetic":
                return new Cosmetic();
            case "Audio":
                return new Audio();
            default:
                return new Code();
        }
    }

    /* creates the bug and asks users for the object details */
    public static AbstractBug createBugFromUserInput() {

        AbstractBug bug = createBug(selectBugType());
        try {
            System.out.println("1. Select the priority 1/2/3/4: ");
            Scanner priority = new Scanner(System.in);
            bug.setPriority(priority.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Invalid argument. Exit program ...");
            System.exit(1);
        }
        System.out.println("2. Enter the summary: ");
        Scanner summary = new Scanner(System.in);
        bug.setSummary(summary.nextLine());

        System.out.println("3. Enter the description: ");
        Scanner description = new Scanner(System.in);
        bug.setDescription(description.nextLine());

        System.out.println("4. How do you reproduce the issue?");
        Scanner stepToReproduce = new Scanner(System.in);
        bug.setStepToReproduce(stepToReproduce.nextLine());

        System.out.println("5. Enter the actual result: ");
        Scanner actual = new Scanner(System.in);
        bug.setActual(actual.nextLine());

        System.out.println("6. Enter the Expected result: ");
        Scanner expected = new Scanner(System.in);
        bug.setExpected(expected.nextLine());

        if (bug instanceof Cosmetic) {
            System.out.println("6. Enter the string ID result: ");
            Scanner stringID = new Scanner(System.in);
            ((Cosmetic) bug).setStringID(stringID.nextLine());
        } else if (bug instanceof Audio) {
            System.out.println("6. Enter the string ID result: ");
            Scanner stringID = new Scanner(System.in);
            ((Audio) bug).setStringID(stringID.nextLine());

            System.out.println("6. Do you need rerecording? yes/No ");
            Scanner rerecording = new Scanner(System.in);
            ((Audio) bug).setRerecording(rerecording.nextLine());
        }

        return bug;
    }

    /* all the following method are intended to create a selectable menu in the console */
    private static int selection() {
        System.out.println("What you want to do.\n" +
                "1. Create\n" +
                "2. Search\n" +
                "3. Modify\n" +
                "4. Delete\n" +
                "5. Exit");
        Scanner userInput = new Scanner(System.in);
        return userInput.nextInt();
    }

    public void menu() {

        switch (selection()) {
            case 1:
                Database database3 = new Database();
                AbstractBug bug1 = UserInput.createBugFromUserInput();
                database3.addBug(bug1);
                menu();

            case 2:
                Database database = new Database();
                if (database.checkIfNull()) {
                    System.out.println("Database is empty");
                    menu();
                } else
                    database.searchBug(askForABug());
            case 3:
                System.out.println("this is not done yet");
                menu();
            case 4:
                Database database2 = new Database();
                if (database2.checkIfNull()) {
                    System.out.println("Database is empty");
                    menu();
                } else
                    database2.deleteBug(askForABug());
            case 5:
                System.exit(0);
        }

    }

    public static int askForABug() {
        System.out.println("Enter a bug number.");
        Scanner userInput = new Scanner(System.in);
        return userInput.nextInt();
    }

}
