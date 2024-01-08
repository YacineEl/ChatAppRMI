import Entity.Message;
import Entity.User;
import ServerService.ServerInterface;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;

public class ClientServices {
    public static void registerNewClient(Scanner scanner, User sender, ServerInterface objetDistant) throws ServerNotActiveException, RemoteException {
        System.out.println("Creating Account");
        System.out.print("Enter Your Phone Number : ");
        String senderPhoneNumber = scanner.nextLine();
        sender.setPhoneNum(senderPhoneNumber);
        System.out.print("Enter Your Name : ");
        String Name = scanner.nextLine();
        sender.setName(Name);
        objetDistant.createAccount(sender.getPhoneNum());
        System.out.println("Account Created");
    }
    public static void sendMessage(Scanner scanner, User receiver, User sender, ServerInterface objetDistant) throws ServerNotActiveException, RemoteException, MalformedURLException, NotBoundException {
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
    }
    public static void returnMessagesToUser(Scanner scanner,User sender,ServerInterface objetDistant) throws RemoteException {
        System.out.println("Enter Your Phone Number: ");
        sender.setPhoneNum(scanner.nextLine());
        System.out.println(objetDistant.returnMessageToUser(sender.getPhoneNum()));
    }
}
