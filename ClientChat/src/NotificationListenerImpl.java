import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NotificationListenerImpl extends UnicastRemoteObject implements NotificationListener {
    User receiver;
    protected NotificationListenerImpl() throws RemoteException {
    }

    @Override
    public void sendNotificationToUser(Message message) throws RemoteException {
        System.out.println("You got new messages");
        System.out.println("From : " + message.getSender().getPhoneNum());
        System.out.println("----"+message.getContent());
    }
}
