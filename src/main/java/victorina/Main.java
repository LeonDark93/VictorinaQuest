package victorina;

import connection.MyDBConnection;
import connection.configs.DefaultConfiguration;
import victorina.sql.DBDataExtractor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("::::::::: Добро пожаловать на Викторину чтобы проверить свои знания :::::::::");
        mainMenu();
    }

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("                 ::::::::::::::МЕНЮ:::::::::::::::::::::");
        System.out.println("                 ::::::::1.Начать Викторину:::::::::::::");
        System.out.println("                 ::::::::2.Выход из Викторину:::::::::::");
        System.out.println("");
        System.out.println("Выберите одну из опции:");
        System.out.print(">>>");
        char choseOption = input.next().charAt(0);
        switch (choseOption) {
            case '1':
                startVictory();
                break;
            case '2':
                System.out.println("                Всего Хорошего!!!");
                System.exit(0);
        }
    }

    public static void startVictory() {

        boolean repeatStartVictory = true;
        while (repeatStartVictory) {
            int countQuestions = 0;
            int allQuestions = 10;
            int sumOfQuestions;
            try {
                Scanner sc = new Scanner(System.in);
                DBDataExtractor dbDataExtractor = new DBDataExtractor(MyDBConnection.getConnectionBy(new DefaultConfiguration()));

                for (int i = 1; i <= 10; i++) {
                    String[] question = dbDataExtractor.getQuestion(i);
                    System.out.println("      " + question[DBDataExtractor.QUESTION]);
                    System.out.println("Введите ваш ответ:");System.out.println("");
                    if (question[DBDataExtractor.ANSWER].equals(sc.next())) {
                        countQuestions++;
                    }
                }
                System.out.println("");
                System.out.println("                 :::::::: Правильных ответов   :::::: " + countQuestions + " ::::::");
                sumOfQuestions = allQuestions - countQuestions;
                System.out.println("                 :::::::: Неправильных ответов :::::: " + sumOfQuestions + " ::::::" );
                System.out.println("");
                System.out.println("");

                Scanner input = new Scanner(System.in);
                System.out.println(":::::::: Начать Заново Викторину :::::: (-/+)");
                System.out.println("");
                System.out.print(">>>");
                System.out.print("");
                char repeatProgram = input.next().charAt(0);

                switch (repeatProgram) {
                    case '+':
                        repeatStartVictory = true;
                        break;
                    case '-':
                        System.out.println("               До свидания!!!");
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


