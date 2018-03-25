package Model;

import Interface.IUser;

import java.util.ArrayList;

public class InfantUserModel extends DependentUserModel implements IUser {
    public InfantUserModel(String username, int age, String status, String[] connections){
        super(username, age, status, connections);
    }

    public void addFriend(String friendName, ArrayList<UserModel> users){
        this.getFriends().add(friendName);
        for (UserModel friend : users){
            if (friend.getUserName().equals(friendName)){
                friend.getFriends().add(this.getUserName());
            }
        }
    }
}
