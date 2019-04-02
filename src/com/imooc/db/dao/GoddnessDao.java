package com.imooc.db.dao;

import com.imooc.db.db.DBUtil;
import com.imooc.db.model.Goddness;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoddnessDao {
    public void addGoddness(Goddness g) throws SQLException {
        Connection conn= DBUtil.getConnection();
        String sql=""+
                "insert into imooc_goddess"+
                "(user_name,sex,age,birthday)"+
                "values(" +
                "?,?,?,?)";
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.execute();
    }
    public void updateGoddness(Goddness g) throws SQLException {
        Connection conn= DBUtil.getConnection();
        String sql=""+
                " update imooc_goddess "+
                " set user_name=?,sex=?,age=?,birthday=? "+
                " where id=?";
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setInt(5,g.getId());
        ptmt.execute();
    }
    public void delGoddness(Integer id) throws SQLException {
        Connection conn= DBUtil.getConnection();
        String sql=""+
                " delete from imooc_goddess "+
                " where id=?";
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setInt(1,id);
        ptmt.execute();
    }
    public List<Goddness> query() throws SQLException {
        Connection conn= DBUtil.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from imooc_goddess");
        List<Goddness> gs=new ArrayList<Goddness>();
        Goddness g=null;
        while (rs.next()){
            g=new Goddness();
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            gs.add(g);
        }
        return gs;
    }
    public List<Goddness> query(List<Map<String,Object>> params) throws SQLException {
        Connection conn= DBUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append("select * from imooc_goddess where 1=1 ");
        if(params!=null&&params.size()>0){
            for(int i=0;i<params.size();i++){
                Map<String,Object> map=params.get(i);
                sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+"");
            }
        }
        PreparedStatement ptmt=conn.prepareStatement(sb.toString());
        ResultSet ts=ptmt.executeQuery();
        List<Goddness> gs=new ArrayList<Goddness>();
        Goddness g=null;
        while (ts.next()){
            g=new Goddness();
            g.setUser_name(ts.getString("user_name"));
            g.setAge(ts.getInt("age"));
            gs.add(g);
        }
        return gs;
    }
    public Goddness get(Integer id) throws SQLException {
        Connection conn= DBUtil.getConnection();
        String sql=""+
                " select * from imooc_goddess "+
                " where id=?";
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setInt(1,id);
        ResultSet rs=ptmt.executeQuery();
        Goddness gs=null;
        while (rs.next()){
            gs=new Goddness();
            gs.setId(rs.getInt("id"));
            gs.setAge(rs.getInt("age"));
            gs.setSex(rs.getInt("sex"));
            gs.setBirthday(rs.getDate("birthday"));
            gs.setUser_name(rs.getString("user_name"));
        }
        return gs;
    }
}
