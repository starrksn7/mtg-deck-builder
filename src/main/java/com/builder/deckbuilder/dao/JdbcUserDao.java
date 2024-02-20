package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Objects;
import com.builder.deckbuilder.model.exceptions.UserNotFoundException;

@Component
public class JdbcUserDao implements UserDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findUserByEmail(String email){
        String sql = "SELECT * FROM users WHERE email = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, email);

        if(result.next()){
            return mapRowToUser(result);
        } else {
            throw new UserNotFoundException();
        }
    }

    public boolean create(String email, String userName, String password){
        String insertSql = "INSERT INTO users (email, userName, password) VALUES (?, ?, ?);";
        String passwordHash = new BCryptPasswordEncoder().encode(password);

        jdbcTemplate.update(insertSql, email, userName, passwordHash);
        return true;
    }
    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }
}
