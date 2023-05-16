package com.builder.deckbuilder.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.builder.deckbuilder.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDao implements UserDao{

    private final UserDao userDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(UserDao userDao, JdbcTemplate jdbcTemplate){
        this.userDao = userDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    public int findIdByUsername(String username){
        String sql = "SELECT user_id FROM users WHERE username ILIKE ?;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, username);

        return id == null ? -1 : id;
    }

    public boolean createUser(String username, String password){
        String sql =  "INSERT INTO users (username, password_hash) VALUES (?, ?) RETURNING user_id;";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        Integer newUserId;
        try {
            newUserId = jdbcTemplate.queryForObject(sql, Integer.class, username, password_hash);
        } catch (DataAccessException e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    public User findByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT user_id, username FROM users WHERE username ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        if(results.next()){
            return mapRowToUser(results);
        }
        throw new UsernameNotFoundException("User " + username + " was not found");
    }

    public List<User> listAllUsers(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username FROM users;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            User user= mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    private User mapRowToUser(SqlRowSet result){
        User user = new User();
        user.setUserId(result.getInt("user_id"));
        user.setUsername(result.getNString("username"));
        return user;
    }
}
