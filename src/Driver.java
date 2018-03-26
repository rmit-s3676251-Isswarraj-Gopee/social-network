import Model.AdultUserModel;
import Model.DependentUserModel;
import Model.UserModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    ArrayList<UserModel> users = MiniNet.USERS;
    Scanner scanner = new Scanner(System.in);

    public Driver(){
        mainMenu();
    }

    private void mainMenu(){
        System.out.println("MiniNet Menu");
        System.out.println("==============================================");
        System.out.println("1. \tList everyone");
        System.out.println("2. \tSelect a person");
        System.out.println("3. \tAdd a new person");
        System.out.println("4. \tFind out the parents of a child");
        System.out.println("5. \tFind out the child of two parents");
        System.out.println("6. \tExit");

        int option = 0;
        try {
            option = scanner.nextInt();
        }
        catch (InputMismatchException exp){
            System.out.println("Invalid Option -- You have not entered a number.");
            mainMenu();
        }

        if (option == 1) {
            listEveryone();
            }

            else if (option == 2){
            String selectedPerson = selectPerson();
            System.out.println("Select action");
            System.out.println("==============================================");
            System.out.println("1. \tView profile");
            System.out.println("2. \tCheck friendship");
            System.out.println("3. \tAdd new friend");
            System.out.println("3. \tRemove friend");
            System.out.println("4. \tUpdate Profile");
            System.out.println("5. \tDelete Profile");
            scanner = new Scanner(System.in);
            int subOption = 0;
            try {
                subOption = scanner.nextInt();
            }
            catch (InputMismatchException exp){
                System.out.println("Invalid Option -- You have not entered a number.");
                mainMenu();
            }
            if (subOption == 1){
                viewProfile(selectedPerson);
            }
            if (subOption == 2){
                checkFriendship(selectedPerson);
            }
            if (subOption == 3){
                removeFriend(selectedPerson);
            }
            if (subOption == 4){
                updateProfile(selectedPerson);
            }
            if (subOption == 5){
                deleteProfile(selectedPerson);
            }
        }
        else if (option == 3){
            addPerson();
        }
        else if (option == 4){
            findParents();
        }
        else if (option == 5){
            findChild();
        }
        else if (option == 6){
            System.exit(0);
        }

    }

    private void updateProfile(String userName){
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                System.out.println("Enter user name:");
                scanner = new Scanner(System.in);
                String newUserName = scanner.nextLine();
                System.out.println("Enter user's age:");
                scanner = new Scanner(System.in);
                int age = 0;
                try {
                    age = scanner.nextInt();
                }
                catch (InputMismatchException exp){
                    System.out.println("Invalid Option -- You have not entered a number.");
                    mainMenu();
                }
                System.out.println("Enter user status:");
                scanner = new Scanner(System.in);
                String status = scanner.nextLine();

                for (int i = 0; i < this.users.size(); i++) {
                    if (this.users.get(i).getUserName().equals(newUserName)) {
                        System.out.println("Username already exists!");
                        break;
                    }
                    else if (i == (this.users.size() - 1)) {
                        if (age >= 17) {
                            this.users.get(i).setUserName(newUserName);
                            this.users.get(i).setStatus(status);
                            this.users.get(i).setAge(age);
                        }
                    }
                    }

                break;
            }
            else if (i == (users.size() - 1)){
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
    }

    private void checkFriendship(String userName){
        scanner = new Scanner(System.in);
        System.out.println("Enter friend's name:");
        String friendName = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                if (this.users.get(i).checkFriendship(friendName)){
                    System.out.println(userName + " and " + friendName + " are friends.");
                }
                else{
                    System.out.println(userName + " and " + friendName + " are not friends.");
                }
                break;
            }
            else if (i == (users.size() - 1)){
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
    }

    private void removeFriend(String userName){
        scanner = new Scanner(System.in);
        System.out.println("Enter friend's name:");
        String friendName = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                this.users.get(i).removeFriend(friendName);
                break;
            }
            else if (i == (users.size() - 1)){
                System.out.println("Error! " + userName + " does not exist!");
            }
            }
    }

    private void findParents(){
        String userName = selectPerson();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                if (this.users.get(i).getClass() == DependentUserModel.class){
                    System.out.println(this.users.get(i).getUserName() + "'s parents are " + ((DependentUserModel) this.users.get(i)).getParents()[0] + " and " + ((DependentUserModel) this.users.get(i)).getParents()[1] );
                }
                else{
                    System.out.println("Error! " + userName + " is not a dependent!");
                }
                break;
            }
            else if (i == (users.size() - 1)){
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
    }

    private void findChild(){
        scanner = new Scanner(System.in);
        System.out.println("Enter parent 1 name:");
        String parent1 = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("Enter parent 2 name:");
        String parent2 = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getClass() == DependentUserModel.class) {
                if ((((DependentUserModel) this.users.get(i)).getParents()[0].equals(parent1) &&  ((DependentUserModel) this.users.get(i)).getParents()[1].equals(parent2)) || (((DependentUserModel) this.users.get(i)).getParents()[0].equals(parent2) &&  ((DependentUserModel) this.users.get(i)).getParents()[1].equals(parent1))){
                    System.out.println(this.users.get(i).getUserName() + " is the child of " + parent1 + " and " + parent2);
                }
                break;
            } else if (i == (this.users.size() - 1)) {
                System.out.println("Error! " + parent1 + " does not exist!");
            }
        }
        mainMenu();
    }

    private void listEveryone(){
        System.out.println("User List:");
        for (UserModel user: this.users) {
            System.out.println(user.getUserName());
        }
        mainMenu();
    }

    private void addPerson(){
        System.out.println("Enter user name:");
        scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("Enter user's age:");
        scanner = new Scanner(System.in);
        int age = 0;
        try {
            age = scanner.nextInt();
        }
        catch (InputMismatchException exp){
            System.out.println("Invalid Option -- You have not entered a number.");
            mainMenu();
        }
        System.out.println("Enter user status:");
        scanner = new Scanner(System.in);
        String status = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                System.out.println("User already exists!");
                break;
            }
            else if (i == (this.users.size() - 1)){
                if (age >= 17){
                    UserModel user = new AdultUserModel(userName, age, status);
                    users.add(user);
                }
                else{
                    System.out.println("Enter parent 1 name:");
                    String parent1 = scanner.nextLine();
                    System.out.println("Enter parent 2 name:");
                    String parent2 = scanner.nextLine();
                    for (int j = 0; j < this.users.size(); j++) {
                        if (this.users.get(j).getUserName().equals(parent1)) {
                            if (this.users.get(j).checkFriendship(parent2)){
                                String[] parents = {parent1, parent2};
                                UserModel user = new DependentUserModel(userName, age, status, parents);
                                users.add(user);
                            }
                            else{
                                System.out.println("Error! Parents are not connected!");
                            }
                            break;
                        }
                        else if (j == (this.users.size() - 1)){
                            System.out.println("Error! " + parent1 + " does not exist!");
                        }
                    }
                }
            }
            }
        mainMenu();
    }

    private String selectPerson() {
        System.out.println("Enter user name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void viewProfile(String userName){
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                System.out.println("Username:\t" + this.users.get(i).getUserName());
                System.out.println("Age:\t" + this.users.get(i).getAge());
                System.out.println("Status:\t" + this.users.get(i).getStatus());
                if (this.users.get(i).getClass() == DependentUserModel.class) {
                    System.out.println("User Type:\tDependent");
                    System.out.println("Parents:\t" + ((DependentUserModel) this.users.get(i)).getParents()[0] + "\t" + ((DependentUserModel) this.users.get(i)).getParents()[1]);
                    //System.out.println(((DependentUserModel)user).getParents()[0]);
                } else {
                    System.out.println("User Type:\tAdult");
                }
                for (String friendName : this.users.get(i).getFriends()) {
                    System.out.println("Friends:");
                    System.out.println(friendName);
                }
                break;
            }
            else if (i == (users.size() - 1)){
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
        }

        private void deleteProfile(String userName){
            for (int i = 0; i < this.users.size(); i++) {
                if (this.users.get(i).getUserName().equals(userName)) {
                    this.users.remove(this.users.get(i));
                    break;
                }
                else if (i == (users.size() - 1)){
                    System.out.println("Error! " + userName + " does not exist!");
                }
            }
            mainMenu();
        }

}
