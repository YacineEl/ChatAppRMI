import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.util.List;
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
                    System.out.println("Creating Account");
                    System.out.print("Enter Your Phone Number : ");
                    String senderPhoneNumber = scanner.nextLine();
                    sender.setPhoneNum(senderPhoneNumber);
                    System.out.print("Enter Your Name : ");
                    String Name = scanner.nextLine();
                    sender.setName(Name);
                    objetDistant.createAccount(sender.getPhoneNum());
                    System.out.println("Account Created");
                    //Launch Notification Service
                    NotificationListener clientRMI = new NotificationListenerImpl();
                    int port = 1100 + Integer.parseInt(senderPhoneNumber);
                    java.rmi.registry.LocateRegistry.createRegistry(port);
                    java.rmi.Naming.rebind("rmi://localhost:"+port+"/MyClientRMI"+senderPhoneNumber,clientRMI);
                    System.out.println("Notification Service Ready.");
                    break;
                case "Message":
                    // --- To be Deleted When creating 2 Clients ---
                    System.out.print("Enter Receiver Phone Number : ");
                    String receiverPhoneNumber = scanner.nextLine();
                    receiver.setPhoneNum(receiverPhoneNumber);
                    objetDistant.createAccount(receiverPhoneNumber);
                    //--------------
                    System.out.print("Message To Send : ");
                    String content = scanner.nextLine();
                    Message message = new Message(sender,receiver,content);
                    objetDistant.sendMessage(message);
                    break;
                case "Exit":
                    stayInLoop = false;
                    break;
                case "Messages Received":
                    System.out.println("Enter Your Phone Number: ");
                    sender.setPhoneNum(scanner.nextLine());
                    System.out.println(objetDistant.returnMessageToUser(sender.getPhoneNum()));
                    break;
                case null, default:
                    System.out.println("Request Not Recognized");
                    break;

            }
        }
        /*
        while(true){
            List<Message> messageList= objetDistant.returnMessageToUser(receiver.getPhoneNum());
            if(messageList!=null)
                System.out.println(messageList);
        }
        */

    }
}