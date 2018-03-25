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

    public void addFriend(String friendName){
        this.friends.add(friendName);
    }
}