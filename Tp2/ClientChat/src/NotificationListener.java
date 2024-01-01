import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NotificationListener extends Remote {
    void sendNotificationToUser(Message message) throws RemoteException;
}
