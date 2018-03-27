package Model;

import Constant.ApplicationConstant;

import java.util.ArrayList;

public class DependentUserModel extends UserModel {

    public DependentUserModel(String userName, int age, String status, String[] parents){
        super(userName, age, status);
        this.getConnections().add(new ConnectionModel(parents[0], ApplicationConstant.PARENT));
        this.getConnections().add(new ConnectionModel(parents[1], ApplicationConstant.PARENT));
    }

//    @Override
//    public void addFriend(String friendName, ArrayList<UserModel> users){
//        //this.friends.add(friendName);
//        for (UserModel friend : users){
//            if (friend.getUserName().equals(friendName)) {
//                if (((this.getAge() > friend.getAge()) && (this.getAge() - friend.getAge() < 3)) || ((friend.getAge() > this.getAge()) && (friend.getAge() - this.getAge() < 3))) {
//                    if (this.getAge() > 2 && friend.getAge() > 2){
//                        this.addFriend(friendName, users);
//                    }
//                }
//            }
//        }
//    }



    public void addFriend(String friendName, ArrayList<UserModel> users){
        ConnectionModel connection = new ConnectionModel(friendName, ApplicationConstant.FRIEND);
        this.getConnections().add(connection);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(friendName) && users.get(i).getAge() <= 16){
                if (((this.getAge() > users.get(i).getAge()) && (this.getAge() - users.get(i).getAge() <= 3)) || ((users.get(i).getAge() > this.getAge()) && (users.get(i).getAge() - this.getAge() <= 3))) {
                    if (this.getAge() > 2 && users.get(i).getAge() > 2) {
                        users.get(i).getConnections().add(new ConnectionModel(this.getUserName(), ApplicationConstant.FRIEND));
                    }
                    else {
                        System.out.println("Error! The age difference between you and " + friendName +  " is more than 3 years!");
                    }
                }
                else{
                    System.out.println("Dependents under 2 years old cannot have friends");
                }
                break;
            }
            else if (users.get(i).getUserName().equals(friendName) && users.get(i).getAge() > 16) {
                System.out.println("Cannot add adult as friend!");
            } else if (i == (users.size() - 1)) {
                {
                    System.out.println("Error! " + friendName + " does not exist!");
                }
            }
        }
    }
}
