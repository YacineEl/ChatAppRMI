package DAO;

import Entity.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageManager {
    public int addMessage(Message message){
        DBInteraction.connect();
        int nb=DBInteraction.Maj("insert into message(senderPhoneNumber,receiverPhoneNum,content) values('"+
                message.getSender().getPhoneNum()+ "', "+
                message.getReceiver().getPhoneNum()+ "', "+
                message.getContent()
                +")");
        DBInteraction.disconnect();
        return nb;
    }

    public List<Message> findReceiverMessageList(String receiverPhoneNumber){
        List<Message> messageList = new ArrayList<Message>();
        DBInteraction.connect();
        ResultSet resultSet = DBInteraction.Select("select * from message where receiverPhoneNum = "+receiverPhoneNumber+",");
        try {
            while(resultSet.next())
            {
                Message message = new Message(resultSet.getString(2),resultSet.getString(2),resultSet.getString(3));
                messageList.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBInteraction.disconnect();
        return messageList;
    }
}
