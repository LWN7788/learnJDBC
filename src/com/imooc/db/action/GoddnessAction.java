package com.imooc.db.action;

import com.imooc.db.dao.GoddnessDao;
import com.imooc.db.model.Goddness;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GoddnessAction {
    public void add(Goddness goddness) throws SQLException {
        GoddnessDao dao=new GoddnessDao();
        dao.addGoddness(goddness);
    }
    public void edit(Goddness goddness) throws SQLException {
        GoddnessDao dao=new GoddnessDao();
        dao.updateGoddness(goddness);
    }
    public void del(Integer id) throws SQLException {
        GoddnessDao dao=new GoddnessDao();
        dao.delGoddness(id);
    }
    public List<Goddness> query() throws SQLException {
        GoddnessDao dao=new GoddnessDao();
        return dao.query();
    }

    public List<Goddness> query(List<Map<String,Object>> params) throws SQLException {
        GoddnessDao dao=new GoddnessDao();
        return dao.query(params);
    }
    public Goddness get(Integer id) throws SQLException {
        GoddnessDao dao=new GoddnessDao();
        return dao.get(id);
    }
    public static void main(String[] args) throws SQLException {

    }
}
