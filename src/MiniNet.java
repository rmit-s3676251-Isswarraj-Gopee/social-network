import Model.AdultUserModel;
import Model.DependentUserModel;
import Model.UserModel;

import java.util.ArrayList;

public class MiniNet {

    public static ArrayList<UserModel> USERS = new ArrayList<>();

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        UserModel alice = new AdultUserModel("Alice", 19, "Student at RMIT");
        UserModel cathy = new AdultUserModel("Cathy", 19, "Technical Architect");
        UserModel bob = new AdultUserModel("Bob", 19, "Software Developer");
        UserModel don = new AdultUserModel("Don", 19, "Tester");

        USERS.add(alice);
        USERS.add(cathy);
        USERS.add(bob);
        USERS.add(don);

        alice.addFriend("Don", USERS);
        alice.addFriend("Bob", USERS);
        cathy.addFriend("Don", USERS);


//        String[] childParents = {"Test","asdas"};
//        UserModel child = new DependentUserModel("Child", 4, "Kintergarden", childParents);
//        USERS.add(user);
//        USERS.add(child);

        Driver driver = new Driver();
    }
}
