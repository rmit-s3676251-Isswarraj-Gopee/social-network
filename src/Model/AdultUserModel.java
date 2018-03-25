package Model;

import Interface.IUser;

import java.util.ArrayList;

public class AdultUserModel extends UserModel implements IUser {
    public AdultUserModel(String userName, int age, String status){
        super(userName, age, status);
    }

    public void addFriend(String friendName, ArrayList<UserModel> users){
        for (UserModel friend : users){
            if (friend.getUserName().equals(friendName)){
                this.getFriends().add(friendName);
                friend.getFriends().add(this.getUserName());
            }
            else{
                System.out.println("Error! User does not exist!");
            }
        }
    }
}
