package org.damon.st.producer.service;

import org.damon.st.producer.model.User;

public interface UsersService {
    Long createUser(User user);
    Long updateUser(User user);
    Long deleteUser(User user);
}
