import Model.AdultUserModel;
import Model.DependentUserModel;
import Model.InfantUserModel;
import Model.UserModel;

import java.util.ArrayList;

public class Main {

    public static ArrayList<UserModel> users = new ArrayList<>();

    public static void main(String[] args) {
        //UserModel userModel = new InfantUserModel();
        //System.out.println("Hello World!");
        UserModel user = new AdultUserModel("Test", 19, "Testing");
        String[] childParents = {"Test","asdas"};
        UserModel child = new DependentUserModel("Child", 4, "kindergarden", childParents);
        users.add(user);
        users.add(child);

        Driver driver = new Driver();
    }
}
