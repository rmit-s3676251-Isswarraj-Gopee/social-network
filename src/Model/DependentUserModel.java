package Model;

import java.util.ArrayList;

public abstract class DependentUserModel extends UserModel {

    private String[] connections = new String[2];

    public DependentUserModel(String userName, int age, String status, String[] connections){
        super(userName, age, status);
        this.connections = connections;
    }

    public String[] getConnections() {
        return connections;
    }

    public void setConnections(String[] connections) {
        this.connections = connections;
    }
}
