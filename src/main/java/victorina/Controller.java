package victorina;

import connection.MyDBConnection;
import connection.configs.DefaultConfiguration;
import victorina.sql.DBDataExtractor;

import java.util.Scanner;

public class Controller {
    void greetings(){
        System.out.println("::::::::: Welcome to the Quiz to test your knowledge :::::::::");
    }
     void mainMenu() {

        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("                 ::::::::::::::MENU:::::::::::::::::::::");
        System.out.println("                 ::::::::1.Start the Quiz:::::::::::::");
        System.out.println("                 ::::::::2.Exit from the Quizlet:::::::::::");
        System.out.println("");
        System.out.println("Select one of the options:");
        System.out.print(">>>");
        char choseOption = input.next().charAt(0);
        switch (choseOption) {
            case '1':
                startVictory();
                break;
            case '2':
                System.out.println("                Have a great day!!!");
                System.exit(0);
        }
    }

     void startVictory() {
        boolean repeatStartVictory = true;
        while (repeatStartVictory) {
            int countQuestions = 0;
            int allQuestions = 3;
            int sumOfQuestions;
            try {
                Scanner sc = new Scanner(System.in);
                DBDataExtractor dbDataExtractor = new DBDataExtractor(MyDBConnection.getConnectionBy(new DefaultConfiguration()));

                for (int i = 1; i <= 3; i++) {
                    String[] question = dbDataExtractor.getQuestion(i);
                    System.out.println("      " + question[DBDataExtractor.QUESTION]);
                    System.out.println("Enter your answer:");
                    System.out.println("");
                    if (question[DBDataExtractor.ANSWER].equals(sc.next())) {
                        countQuestions++;
                    }
                }


                System.out.println("");
                System.out.println("                 :::::::: Correct answers   :::::: " + countQuestions + " ::::::");
                sumOfQuestions = allQuestions - countQuestions;
                System.out.println("                 :::::::: Incorrect answers :::::: " + sumOfQuestions + " ::::::" );
                System.out.println("");
                System.out.println("");

                Scanner input = new Scanner(System.in);
                System.out.println(":::::::: Restart the Quiz :::::: (-/+)");
                System.out.println("");
                System.out.print(">>>");
                System.out.print("");
                char repeatProgram = input.next().charAt(0);

                switch (repeatProgram) {
                    case '+':
                        repeatStartVictory = true;
                        break;
                    case '-':
                        System.out.println("               Goodbye!!!");
                        repeatStartVictory = false;
                        break;
                    default:
                        System.out.println("Unknown Error!!!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
