import Constant.ApplicationConstant;
import Model.AdultUserModel;
import Model.ConnectionModel;
import Model.DependentUserModel;
import Model.UserModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    private ArrayList<UserModel> users = MiniNet.USERS;
    private Scanner scanner = new Scanner(System.in);

    public Driver() {
        mainMenu();
    }

    private void mainMenu() {
        System.out.println("MiniNet Menu");
        System.out.println("==============================================");
        System.out.println("1. \tList everyone");
        System.out.println("2. \tSelect a person");
        System.out.println("3. \tAdd a new person");
        System.out.println("4. \tFind out the parents of a child");
        System.out.println("5. \tFind out the child(ren) of a parent");
        System.out.println("6. \tExit");

        int option = getOption();
//        try {
//            option = scanner.nextInt();
//        } catch (InputMismatchException exp) {
//            System.out.println("Invalid Option -- You have not entered a number.");
//            scanner = new Scanner(System.in);
//            option = scanner.nextInt();
//        }

        if (option == 1) {
            listEveryone();
        } else if (option == 2) {
            String selectedPerson = selectPerson();
            System.out.println("Select action");
            System.out.println("==============================================");
            System.out.println("1. \tView profile");
            System.out.println("2. \tCheck friendship");
            System.out.println("3. \tAdd new friend");
            System.out.println("4. \tRemove friend");
            System.out.println("5. \tUpdate Profile");
            System.out.println("6. \tDelete Profile");
            scanner = new Scanner(System.in);
            int subOption = getOption();
//            try {
//                subOption = scanner.nextInt();
//            } catch (InputMismatchException exp) {
//                System.out.println("Invalid Option -- You have not entered a number.");
//                  mainMenu();
//            }
            if (subOption == 1) {
                viewProfile(selectedPerson);
            }
            if (subOption == 2) {
                checkFriendship(selectedPerson);
            }
            if (subOption == 3) {
                addFriend(selectedPerson);
            }
            if (subOption == 4) {
                removeFriend(selectedPerson);
            }
            if (subOption == 5) {
                updateProfile(selectedPerson);
            }
            if (subOption == 6) {
                deleteProfile(selectedPerson);
            }
        } else if (option == 3) {
            addPerson();
        } else if (option == 4) {
            findParents();
        } else if (option == 5) {
            findChild();
        } else if (option == 6) {
            System.exit(0);
        }

    }

    private int getOption(){
        int option = 0;
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        }
        else{
            System.out.println("Invalid Option -- You have not entered a number.");
            System.out.println("Enter your option again.");
            scanner.next();
            return getOption();
        }
    }

    private void addFriend(String userName) {
        scanner = new Scanner(System.in);
        System.out.println("Enter friend's name:");
        String friendName = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                this.users.get(i).addFriend(friendName, this.users);
                break;
            } else if (i == (users.size() - 1)) {
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
    }

    private void updateProfile(String userName) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                System.out.println("Enter new user name:");
                scanner = new Scanner(System.in);
                String newUserName = scanner.nextLine();
                System.out.println("Enter new user's age:");
                scanner = new Scanner(System.in);
                int age = 0;
                try {
                    age = scanner.nextInt();
                } catch (InputMismatchException exp) {
                    System.out.println("Invalid Option -- You have not entered a number.");
                    mainMenu();
                }
                System.out.println("Enter new user status:");
                scanner = new Scanner(System.in);
                String status = scanner.nextLine();

                for (int j = 0; j < this.users.size(); j++) {
                    if (this.users.get(j).getUserName().equals(newUserName)) {
                        System.out.println("Username already exists!");
                        break;
                    } else if (j == (this.users.size() - 1)) {
                        if (age >= 17) {
                            if (!this.users.get(j).getUserName().equals(newUserName)) {
                                for (UserModel user: this.users){
                                    for (ConnectionModel connection: user.getConnections())
                                    {
                                        if (connection.getConnectionName().equals(this.users.get(i).getUserName())){
                                            connection.setConnectionName(newUserName);
                                        }
                                    }
                                }
                                this.users.get(i).setUserName(newUserName);
                            }
                            this.users.get(j).setStatus(status);
                            this.users.get(j).setAge(age);
                        }
                    }
                }
                break;
            } else if (i == (users.size() - 1)) {
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
    }

    private void checkFriendship(String userName) {
        scanner = new Scanner(System.in);
        System.out.println("Enter friend's name:");
        String friendName = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                if (this.users.get(i).checkFriendship(friendName)) {
                    System.out.println(userName + " and " + friendName + " are friends.");
                } else {
                    System.out.println(userName + " and " + friendName + " are not friends.");
                }
                break;
            } else if (i == (users.size() - 1)) {
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
    }

    private void removeFriend(String userName) {
        scanner = new Scanner(System.in);
        System.out.println("Enter friend's name:");
        String friendName = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                for (int j = 0; j < this.users.size(); j++) {
                    if (this.users.get(j).getUserName().equals(friendName)) {
                        this.users.get(i).removeConnection(friendName);
                        this.users.get(j).removeConnection(userName);
                    } else if (i == (users.size() - 1)) {
                        System.out.println("Error! " + friendName + " does not exist!");
                    }

                }
                break;
            } else if (i == (users.size() - 1)) {
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
    }

    private void findParents() {
        String userName = selectPerson();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                if (this.users.get(i).getClass() == DependentUserModel.class) {
                    ArrayList<String> parents = new ArrayList<>();
                    for (ConnectionModel connectionModel : this.users.get(i).getConnections()) {
                        if (connectionModel.getConnectionType().equals(ApplicationConstant.PARENT)) {
                            parents.add(connectionModel.getConnectionName());
                            if (parents.size() == 2)
                                break;
                        }
                    }
                    System.out.println(this.users.get(i).getUserName() + "'s parents are " + parents.get(0) + " and " + parents.get(1));
                } else {
                    System.out.println("Error! " + userName + " is not a dependent!");
                }
                break;
            } else if (i == (users.size() - 1)) {
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
    }

    private void findChild() {
        scanner = new Scanner(System.in);
        System.out.println("Enter parent name:");
        String parentName = scanner.nextLine();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(parentName)) {
                System.out.println("Child(ren):");
                for (ConnectionModel connectionModel : this.users.get(i).getConnections()) {
                    if (connectionModel.getConnectionType().equals(ApplicationConstant.CHILD))
                        System.out.println(connectionModel.getConnectionName());
                }
                break;
            } else if (i == (this.users.size() - 1)) {
                System.out.println("Error! " + parentName + " does not exist!");
            }
        }
        mainMenu();
    }

    private void listEveryone() {
        System.out.println("User List:");
        for (UserModel user : this.users) {
            System.out.println(user.getUserName());
        }
        mainMenu();
    }

    private void addPerson() {
        System.out.println("Enter user name:");
        scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("Enter user's age:");
        scanner = new Scanner(System.in);
        int age = 0;
        try {
            age = scanner.nextInt();
        } catch (InputMismatchException exp) {
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
            } else if (i == (this.users.size() - 1)) {
                if (age >= 17) {
                    UserModel user = new AdultUserModel(userName, age, status);
                    users.add(user);
                } else {
                    System.out.println("Enter parent 1 name:");
                    String parent1 = scanner.nextLine();
                    System.out.println("Enter parent 2 name:");
                    String parent2 = scanner.nextLine();
                    for (int j = 0; j < this.users.size(); j++) {
                        if (this.users.get(j).getUserName().equals(parent1) || this.users.get(j).getUserName().equals(parent2)) {
                            if ((this.users.get(j).getUserName().equals(parent1) && this.users.get(j).checkFriendship(parent2)) || (this.users.get(j).getUserName().equals(parent2) && this.users.get(j).checkFriendship(parent1))) {
                                String[] parents = {parent1, parent2};
                                UserModel user = new DependentUserModel(userName, age, status, parents);
                                users.add(user);
                                this.users.get(j).getConnections().add(new ConnectionModel(userName, ApplicationConstant.PARENT));
                            } else {
                                System.out.println("Error! Parents are not connected!");
                            }
                            for (int z = j; z < this.users.size(); z++) {
                                if (this.users.get(j).getUserName().equals(parent1) && this.users.get(z).getUserName().equals(parent2)) {
                                    this.users.get(z).getConnections().add(new ConnectionModel(userName, ApplicationConstant.CHILD));
                                    break;
                                } else if (this.users.get(j).getUserName().equals(parent2) && this.users.get(z).getUserName().equals(parent1)) {
                                    this.users.get(z).getConnections().add(new ConnectionModel(userName, ApplicationConstant.CHILD));
                                    break;
                                }
                            }
                            break;
                        } else if (j == (this.users.size() - 1)) {
                            System.out.println("Error! " + parent1 + " does not exist!");
                        }
                    }
                }
                break;
            }
        }
        mainMenu();
    }

    private String selectPerson() {
        System.out.println("Enter user name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void viewProfile(String userName) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                System.out.println("Username:\t" + this.users.get(i).getUserName());
                System.out.println("Age:\t" + this.users.get(i).getAge());
                System.out.println("Status:\t" + this.users.get(i).getStatus());
                if (this.users.get(i).getClass() == DependentUserModel.class) {
                    System.out.println("User Type:\tDependent");
                } else {
                    System.out.println("User Type:\tAdult");
                }
                System.out.println("Connections:");
                for (ConnectionModel connection : this.users.get(i).getConnections()) {
                    System.out.println("\t" + connection.getConnectionName() + "\t" + connection.getConnectionType());
                }
                break;
            } else if (i == (users.size() - 1)) {
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
    }

    private void deleteProfile(String userName) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(userName)) {
                    this.users.get(i).setUserName(userName);
                    Boolean canDelete = true;
                    for (UserModel user: this.users){
                        for (int j = 0; j < user.getConnections().size(); j++)
                        {
                            if (user.getConnections().get(j).getConnectionName().equals(userName) && user.getConnections().get(j).getConnectionType().equals(ApplicationConstant.PARENT)){
                                canDelete = false;
                                System.out.println("Error! Cannot delete this user! Is the parent to child.");
                                break;
                            }
                        }
                    }
                    if (canDelete){
                        for (UserModel user: this.users){
                            for (int j = 0; j < user.getConnections().size(); j++)
                            {
                                if (user.getConnections().get(j).getConnectionName().equals(userName)){
                                    user.getConnections().remove(user.getConnections().get(j));
                                }
                            }
                        }
                        this.users.remove(this.users.get(i));
                    }
                    break;
            } else if (i == (users.size() - 1)) {
                System.out.println("Error! " + userName + " does not exist!");
            }
        }
        mainMenu();
    }

}
