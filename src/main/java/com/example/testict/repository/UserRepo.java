

package com.example.testict.repository;

import com.example.testict.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findTop1ByEmail (String email);
    public User findTop1ByUsername (String username);
}