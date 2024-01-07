package ClientInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Entity.Message;

public class NotificationListenerImpl extends UnicastRemoteObject implements NotificationListener {
    public NotificationListenerImpl() throws RemoteException {
    }

    @Override
    public void sendNotificationToUser(Message message) throws RemoteException {
        System.out.println("You got new messages");
        System.out.println("From : " + message.getSender().getPhoneNum());
        System.out.println("----"+message.getContent());
    }
}
