package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.User;
import com.builder.deckbuilder.model.UserDTO;
import com.builder.deckbuilder.model.exceptions.UserNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

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

    @Override
    public User updateUserProfile(int userId, UserDTO updatedUser) {
        String sql = "UPDATE users\n" +
                "SET email = ?,\n" +
                "username = ?\n" +
                "WHERE user_id = ?;";
        jdbcTemplate.update(sql,updatedUser.getEmail(),updatedUser.getUserName(), userId);

        return getUserById(userId);
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
