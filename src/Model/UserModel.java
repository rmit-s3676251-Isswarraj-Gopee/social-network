package Model;

import java.util.ArrayList;

public abstract class UserModel {
    private String userName;
    private int age;
    private String status;

    private ArrayList<String> friends;

    public UserModel(String userName, int age, String status){
        this.userName = userName;
        this.age = age;
        this.status = status;
        this.friends = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public boolean verifyFriendship(String userName1, String userName2, ArrayList<UserModel> users){
        for (UserModel user : users){
            if (user.getUserName().equals(userName1)) {
                for (String friendName : user.getFriends()) {
                    if (friendName.equals(userName2)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public abstract void addFriend(String friendName, ArrayList<UserModel> users);

//    public void addFriend(String friendName, ArrayList<UserModel> users){
//        this.friends.add(friendName);
//        for (UserModel friend : users){
//            if (friend.getUserName().equals(friendName)){
//                friend.friends.add(this.userName);
//            }
//        }
//    }
}
