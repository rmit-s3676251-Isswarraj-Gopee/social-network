/**
 * @author Isswarraj Gopee
 */

package Model;

import Constant.ApplicationConstant;

public class AdultUserModel extends UserModel {
    public AdultUserModel(String userName, int age, String status) {
        super(userName, age, status);
    }

    public void addFriend(UserModel friend) {
        if (friend.getAge() > 16) {
            this.getConnections().add(new ConnectionModel(friend.getUserName(), ApplicationConstant.FRIEND));
            friend.getConnections().add(new ConnectionModel(this.getUserName(), ApplicationConstant.FRIEND));
        } else if (friend.getAge() < 16) {
            System.out.println("Cannot add dependent as friend!");
        }
    }

}
