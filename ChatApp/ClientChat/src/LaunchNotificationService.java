import ClientInterface.NotificationListener;
import ClientInterface.NotificationListenerImpl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class LaunchNotificationService {
    private String senderPhoneNumber;
    public LaunchNotificationService(String senderPhoneNumber) throws RemoteException, MalformedURLException {
        NotificationListener clientRMI = new NotificationListenerImpl();
        int port = 1100 + Integer.parseInt(senderPhoneNumber);
        java.rmi.registry.LocateRegistry.createRegistry(port);
        java.rmi.Naming.rebind("rmi://localhost:"+port+"/MyClientRMI"+senderPhoneNumber,clientRMI);
        System.out.println("Notification Service Ready.");
    }
}
