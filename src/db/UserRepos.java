package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepos {
    private final StudentDB db;

    public UserRepos(StudentDB db) {
        this.db = db;
    }
    public User getById(int id) {
        User userById = null;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);

            ResultSet res = st.executeQuery();

            if(res.next()){
                userById = new User(res.getInt("id"), res.getString("name"), res.getString("surname"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userById;
    }
}
