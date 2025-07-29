package com.day6proj2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.day6proj2.entity.Bug;
import com.day6proj2.util.DbUtil;

public class BugRepositoryImpl implements BugRepository{
    public void insertBug(Bug b)
    {  DbUtil db=new DbUtil();
          try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("INSERT INTO bugtable(title,description,status) VALUES(?,?,?)");
            ps.setString(1, b.getTitle());
            ps.setString(2,b.getDescription());
            ps.setString(3,b.getStatus());
            ps.executeUpdate();
            System.out.println("Bug Inserted"); 
          } catch (Exception e) {
            e.printStackTrace();
          }
       }
    public List<Bug> viewAllBugs(){
        DbUtil db=new DbUtil();
        List<Bug> l=new ArrayList<>();
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM bugtable");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Bug b=new Bug();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setDescription(rs.getString("description"));
                b.setStatus(rs.getString("status"));
                l.add(b);
            }
            l.sort((b1,b2)-> Integer.compare(b1.getId(), b2.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
    public void updateStatus(Bug b){
        DbUtil db=new DbUtil();
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("UPDATE bugtable SET status=? WHERE id=?");
            ps.setString(1,b.getStatus());
            ps.setInt(2,b.getId());
            ps.executeUpdate();
            System.out.println("Bug Updated");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteBug(Bug b){
         DbUtil db=new DbUtil();
        try {
            Connection con=db.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM bugtable WHERE id=?");
            ps.setInt(1,b.getId());
            ps.executeUpdate();
            System.out.println("Bug Deleted");
            
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    
}
