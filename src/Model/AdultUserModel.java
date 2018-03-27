package Model;

import Constant.ApplicationConstant;
import Interface.IUser;

import java.util.ArrayList;

public class AdultUserModel extends UserModel implements IUser {
    public AdultUserModel(String userName, int age, String status) {
        super(userName, age, status);
    }

    public void addFriend(String friendName, ArrayList<UserModel> users) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(friendName) && users.get(i).getAge() > 16) {
                this.getConnections().add(new ConnectionModel(friendName, ApplicationConstant.FRIEND));
                users.get(i).getConnections().add(new ConnectionModel(this.getUserName(), ApplicationConstant.FRIEND));
                break;
            }
            else if (users.get(i).getUserName().equals(friendName) && users.get(i).getAge() < 16) {
                System.out.println("Cannot add dependent as friend!");
                break;
            } else if (i == (users.size() - 1)) {
                    System.out.println("Error! " + friendName + " does not exist!");
            }
        }
    }
}
