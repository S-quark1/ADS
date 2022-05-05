package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepos {
    private final StudentDB db;

    public StudentRepos(StudentDB db) {
        this.db = db;
    }

    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM users ORDER BY id";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet res = st.executeQuery();

            while(res.next()){
                Student student = new Student(res.getInt("id"), res.getString("name"), res.getString("surname"));
                students.add(student);
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
        return students;
    }

    public Student getById(int id) {
        Student studentById = null;
        Connection con = null;
        try{
            con = db.getCon();
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);

            ResultSet res = st.executeQuery();

            if(res.next()){
                studentById = new Student(res.getInt("id"), res.getString("name"), res.getString("surname"));
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
        return studentById;
    }
}
