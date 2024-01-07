import ServerService.ServerImpl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;


public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException, InterruptedException, NotBoundException, ServerNotActiveException {
        ServerImpl serverRMI = new ServerImpl();
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        java.rmi.Naming.rebind("rmi://localhost:1099/MyServerRMI",serverRMI);
        System.out.println("Server RMI ready");

        //serverRMI.getMsg();
    }
}