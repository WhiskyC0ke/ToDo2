import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String nazwazadania;
    String opiszadania;
    boolean czyukonczono;

    public Task(String nazwazadania, String opiszadania) {
        this.nazwazadania = nazwazadania;
        this.opiszadania = opiszadania;
        this.czyukonczono = false;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int wybor;
        do {
            printMenu();
            wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    addTask(tasks, scanner);
                    break;
                case 2:
                    markTaskAsCompleted(tasks, scanner);
                    break;
                case 3:
                    removeTask(tasks, scanner);
                    break;
                case 4:
                    displayTasks(tasks);
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Podaj poprawna opcje.");
            }

        } while (wybor != 5);
    }

    private static void printMenu() {
        System.out.print("\nWybierz opcje (Wprowadz numer akcji): \n");
        System.out.print("1. Dodaj nowe zadanie \n");
        System.out.print("2. Oznacz zadanie jako zakonczone \n");
        System.out.print("3. Usun zadanie \n");
        System.out.print("4. Wyswietl liste zadan\n");
        System.out.print("5. Zakoncz program\n");
    }

    private static void addTask(ArrayList<Task> tasks, Scanner scanner) {
        System.out.println("Podaj nazwe zadania: ");
        String nazwazadania = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String opiszadania = scanner.nextLine();
        tasks.add(new Task(nazwazadania, opiszadania));
        System.out.println("Zadanie " + nazwazadania + " zostalo dodane do listy.");
    }

    private static void markTaskAsCompleted(ArrayList<Task> tasks, Scanner scanner) {
        displayTasks(tasks);
        System.out.print("Podaj numer zadania do oznaczenia jako zakonczone: ");
        int taskNumber = scanner.nextInt();
        if (isValidTaskNumber(taskNumber, tasks.size())) {
            Task task = tasks.get(taskNumber - 1);
            task.czyukonczono = true;
            System.out.println("Zadanie " + task.nazwazadania + " zostało oznaczone jako zakonczone.");
        } else {
            System.out.println("Niepoprawny numer zadania. Sprobuj ponownie.");
        }
    }

    private static void removeTask(ArrayList<Task> tasks, Scanner scanner) {
        displayTasks(tasks);
        System.out.println("Podaj numer zadania do usuniecia: ");
        int taskNumber = scanner.nextInt();
        if (isValidTaskNumber(taskNumber, tasks.size())) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Zadanie " + removedTask.nazwazadania + " zostalo usuniete z listy.");
        } else {
            System.out.println("Niepoprawny numer zadania. Sprobuj ponownie.");
        }
    }

    private static void displayTasks(ArrayList<Task> tasks) {
        System.out.println("Lista zadan: ");
        if (tasks.isEmpty()) {
            System.out.println("Brak zadan");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                String status = task.czyukonczono ? "[x]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + task.nazwazadania + ": " + task.opiszadania);
            }
        }
    }

    private static boolean isValidTaskNumber(int taskNumber, int totalTasks) {
        return taskNumber >= 1 && taskNumber <= totalTasks;
    }
}