import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatApp {
    private User user;
    private HashMap<String, List<String>> messagesReceived = new HashMap<>();
    private HashMap<String,List<String>> messagesSent = new HashMap<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, List<String>> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(HashMap<String, List<String>> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    public HashMap<String, List<String>> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(HashMap<String, List<String>> messagesSent) {
        this.messagesSent = messagesSent;
    }


}
