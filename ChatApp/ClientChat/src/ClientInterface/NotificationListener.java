package ClientInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Entity.Message;
public interface NotificationListener extends Remote {
    void sendNotificationToUser(Message message) throws RemoteException;
}
