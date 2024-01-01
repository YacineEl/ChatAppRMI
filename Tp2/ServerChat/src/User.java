import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String PhoneNum;
    private HashMap<String, ArrayList<String>> messagesReceived = new HashMap<>();

    private HashMap<String,ArrayList<String>> messagesSent = new HashMap<>();

    public User(String name, String phoneNum) {
        this.name = name;
        PhoneNum = phoneNum;
    }
    public User(String phoneNum) {
        this.PhoneNum = phoneNum;
    }

    public User() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public HashMap<String, ArrayList<String>> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(HashMap<String, ArrayList<String>> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public HashMap<String, ArrayList<String>> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(HashMap<String, ArrayList<String>> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", PhoneNum='" + PhoneNum + '\'' +
                '}';
    }
}
