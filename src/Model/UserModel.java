/**
 * @author Isswarraj Gopee
 */

package Model;

import Constant.ApplicationConstant;

import java.util.ArrayList;

public abstract class UserModel {
    private String userName;
    private int age;
    private String status;

    private ArrayList<ConnectionModel> connections;

    public UserModel(String userName, int age, String status){
        this.userName = userName;
        this.age = age;
        this.status = status;
        connections = new ArrayList<>();
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

    public ArrayList<ConnectionModel> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<ConnectionModel> connections) {
        this.connections = connections;
    }

    public boolean checkFriendship(String friendName){
        for (ConnectionModel connnection : this.getConnections()){
            if (connnection.getConnectionType().equals(ApplicationConstant.FRIEND) && connnection.getConnectionName().equals(friendName))
                return true;
        }
        return false;
    }

    public void removeConnection(String connectionName){
        for (int i = 0; i < this.connections.size(); i++){
            if (this.connections.get(i).getConnectionName().equals(connectionName)){
                connections.remove(this.connections.get(i));
                break;
            }
            else if (i == (this.connections.size() - 1)){
                System.out.println("Error! " + userName + " is not a connection!");
            }
        }
    }

    public abstract void addFriend(UserModel friend);

}
