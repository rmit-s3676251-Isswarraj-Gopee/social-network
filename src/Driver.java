import Model.AdultUserModel;
import Model.DependentUserModel;
import Model.UserModel;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public Driver(){
        MainMenu();
    }

    private void MainMenu(){
        System.out.println("MiniNet Menu");
        System.out.println("==============================================");
        System.out.println("1. \tList everyone");
        System.out.println("2. \tView profile");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option == 1) {
            listEveryone(Main.users);
            }

            else if (option == 2){
            viewProfile();
        }

    }

    private void listEveryone(ArrayList<UserModel> users){
        System.out.println("User List:");
        for (UserModel user: Main.users) {
            System.out.println(user.getUserName());
        }
        MainMenu();
    }

    private void viewProfile(){
        System.out.println("Enter user name:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        for (UserModel user: Main.users) {
            if (user.getUserName().equals(username)) {
                System.out.println("Username:\t" + user.getUserName());
                System.out.println("Age:\t" + user.getAge());
                System.out.println("Status:\t" + user.getStatus());
                if (user.getClass() == DependentUserModel.class) {
                    System.out.println("User Type:\tDependent");
                    System.out.println("Parents:\t" + ((DependentUserModel) user).getParents()[0] + "\t" + ((DependentUserModel) user).getParents()[1]);
                    //System.out.println(((DependentUserModel)user).getParents()[0]);
                } else {
                    System.out.println("User Type:\tAdult");
                }
                for (String friendName: user.getFriends()){
                    System.out.println("Friends:");
                    System.out.println(friendName);
                }
            }

        }
        MainMenu();
    }

}
