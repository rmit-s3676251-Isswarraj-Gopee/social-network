package Interface;

import Model.UserModel;

import java.util.ArrayList;

public interface IUser {
    public void addFriend(String friendName, ArrayList<UserModel> users);
}
