package dao;

import model.User;

import java.util.Optional;

public interface UserDao {
    User save(User user);

    Optional<User> get(Long id);
}
