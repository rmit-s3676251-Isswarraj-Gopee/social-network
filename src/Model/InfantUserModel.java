package Model;

import Interface.IUser;

public class InfantUserModel extends DependentUserModel implements IUser {
    public InfantUserModel(String username, int age, String status, String[] connections){
        super(username, age, status, connections);
    }

    public void addNewFriend(String friendName){

    }
}
