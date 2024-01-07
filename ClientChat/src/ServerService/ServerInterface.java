package ServerService;

import Entity.Message;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.util.List;

public interface ServerInterface extends Remote {
    void createAccount(String PhoneNumber) throws RemoteException, ServerNotActiveException;
    void sendMessage(Message message) throws RemoteException, MalformedURLException, NotBoundException;
    List<Message> returnMessageToUser(String userPhoneNumber) throws RemoteException;
    void sendNotification(Message message) throws RemoteException, MalformedURLException, NotBoundException;
}
