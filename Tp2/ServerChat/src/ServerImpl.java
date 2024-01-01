import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    //User user;
    private HashMap<String, User> contacts;
    private HashMap<String, ArrayList<Message>> msg;
    private HashMap<String,String> connectedClients;

    public HashMap<String, ArrayList<Message>> getMsg() {
        for(String key : msg.keySet()){
            System.out.println(key);
            System.out.println(msg.get(key));
        }
        return msg;
    }

    public ServerImpl() throws RemoteException, MalformedURLException, NotBoundException {
        super();
        contacts = new HashMap<>();
        msg = new HashMap<>();
        connectedClients = new HashMap<>();
    }

    @Override
    public void createAccount(String PhoneNumber) throws RemoteException, ServerNotActiveException {
        // Create User object + add it to Contact list
        User user = new User(PhoneNumber);
        contacts.put(user.getPhoneNum(), user);
        System.out.println("Account Created");
        System.out.println(user);
        // Add field for contact in msg
        msg.put(user.getPhoneNum(),new ArrayList<>());
        connectedClients.put(RemoteServer.getClientHost(),PhoneNumber);
        System.out.println(connectedClients);
    }
    @Override
    public void sendMessage(Message message) throws RemoteException, MalformedURLException, NotBoundException {
        if(!msg.containsKey(message.getSender().getPhoneNum())){
            System.out.println("Sender with Phone Number "+ message.getSender().getPhoneNum() +" Not Registered");
            return;// Leave Method if receiver not registered
        }
        if(!msg.containsKey(message.getReceiver().getPhoneNum())){
            System.out.println("Receiver with Phone Number "+ message.getReceiver().getPhoneNum() +" Not Registered");
            return;// Leave Method if receiver not registered
        }
        // Update ArrayList Associated With Receiver -- Doesn't Feel Optimized --
        ArrayList<Message> messageList = msg.get(message.getReceiver().getPhoneNum());
        messageList.add(message);
        msg.replace(message.getSender().getPhoneNum(),messageList);
        System.out.println("Msg Sent from: " + message.getSender().getPhoneNum() + " to: "+ message.getReceiver().getPhoneNum());
        //System.out.println(messageList);
        this.sendNotification(message);
    }

    @Override
    public List<Message> returnMessageToUser(String userPhoneNumber) throws RemoteException {
        List<Message> msgToSend= new ArrayList<>();
        List<Message> messageList=msg.get(userPhoneNumber);
        for(Message message : messageList){
            if (!message.isStatus()){
                msgToSend.add(message);
                message.setStatus(true);
            }
        }
       if(msgToSend.isEmpty()){
            return null;
        }
        return msgToSend;
    }

    @Override
    public void sendNotification(Message message) throws RemoteException, MalformedURLException, NotBoundException {
        String receiverPhoneNumber = message.getReceiver().getPhoneNum();
        try {
            int port = 1100 + Integer.parseInt(receiverPhoneNumber);
            NotificationListener objetDistant = (NotificationListener) Naming.lookup("rmi://localhost:"+port+"/MyClientRMI"+receiverPhoneNumber);
            objetDistant.sendNotificationToUser(message);
            System.out.println("Notification sent to Client");
        }catch (NotBoundException exception){
            System.out.println("Client Not Connected");
        }

    }
/*
    @Override
    public String sendNotification(String receiverPhoneNumber) throws RemoteException, MalformedURLException, NotBoundException {
        ClientInterface objectDistant = (ClientInterface) Naming.lookup("rmi://localhost/MyClientRMI" + receiverPhoneNumber);
        if()
    }

 */



}
