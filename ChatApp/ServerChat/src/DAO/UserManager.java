package DAO;

import Entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserManager {

    public int addUser(User user)
    {
        DBInteraction.connect();
        int nb=DBInteraction.Maj("insert into user(PhoneNumber,name) values('"+user.getPhoneNum()+"', "+user.getName()+")");
        DBInteraction.disconnect();
        return nb;
    }

    public User findUserByPhoneNum(String PhoneNumber)
    {
        User user=null;
        DBInteraction.connect();
        ResultSet rs = DBInteraction.Select("select * from user where phoneNum="+PhoneNumber);
        try {
            if(rs.next())
            {
                user=new User(rs.getString(1),rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBInteraction.disconnect();
        return user;
    }

    public List<User> allUsers()
    {
        List<User> users = new ArrayList<User>();
        DBInteraction.connect();
        ResultSet rs = DBInteraction.Select("select * from user");
        try {
            while(rs.next())
            {
                User user = new User(rs.getString(1),rs.getString(2));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBInteraction.disconnect();
        return users;
    }
}

