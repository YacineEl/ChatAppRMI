import Entity.User;
import ServerService.ServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, ServerNotActiveException {
        ServerInterface objetDistant = (ServerInterface) Naming.lookup("rmi://localhost/MyServerRMI");

        Scanner scanner = new Scanner(System.in);
        User sender = new User();
        User receiver = new User();

        boolean stayInLoop = true;
        while(stayInLoop){
            System.out.print("Choose request [Register] or [Message] or [Messages Received] or [Exit]: ");
            String request = scanner.nextLine();
            switch(request){
                case "Register":
                    // Register user in Server
                    ClientServices.registerNewClient(scanner,sender,objetDistant);
                    //Launch Notification Service
                    LaunchNotificationService notificationService = new LaunchNotificationService(sender.getPhoneNum());
                    break;
                case "Message":
                    // Send Entity.Message to receiver
                    ClientServices.sendMessage(scanner,receiver,sender,objetDistant);
                    break;
                case "Exit":
                    stayInLoop = false;
                    break;
                case "Messages Received": // Mistake Here -- returns Messages sent
                    ClientServices.returnMessagesToUser(scanner,sender,objetDistant);
                    break;
                case null, default:
                    System.out.println("Request Not Recognized");
                    break;

            }
        }


        /*
        while(true){
            List<Entity.Message> messageList= objetDistant.returnMessageToUser(receiver.getPhoneNum());
            if(messageList!=null)
                System.out.println(messageList);
        }
        */

    }
}