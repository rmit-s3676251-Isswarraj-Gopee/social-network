package Model;

import java.util.ArrayList;

public class DependentUserModel extends UserModel {

    private String[] parents = new String[2];

    public DependentUserModel(String userName, int age, String status, String[] parents){
        super(userName, age, status);
        this.parents = parents;
    }

    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
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
        this.getFriends().add(friendName);
        for (UserModel friend : users){
            if (friend.getUserName().equals(friendName)){
                if (((this.getAge() > friend.getAge()) && (this.getAge() - friend.getAge() <= 3)) || ((friend.getAge() > this.getAge()) && (friend.getAge() - this.getAge() <= 3))) {
                    if (this.getAge() > 2 && friend.getAge() > 2) {
                        friend.getFriends().add(this.getUserName());
                    }
                }
                break;
            }
        }
    }
}
