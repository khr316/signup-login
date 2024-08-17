package com.example.sign.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jt;

    public void insertSignup(String username,
                               String email,
                               String password){
        String sqlStmt = "insert into user(username,email,password) ";
               sqlStmt += "values(?,?,?)";
        jt.update(sqlStmt, username,email,password);
    }

    public int selectCntUser(String email,
                             String password){
        String sqlStmt = "select count(*) from user ";
               sqlStmt += "where email = ? and ";
               sqlStmt += "password = ?";
        return jt.queryForObject(sqlStmt, int.class, email, password);
    }

    public boolean isEmailExists(String email) {
        String sqlStmt = "select count(*) from user where email = ?";
        return jt.queryForObject(sqlStmt, int.class, email) > 0;
    }

}
