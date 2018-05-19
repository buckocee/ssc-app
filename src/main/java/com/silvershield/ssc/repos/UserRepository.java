package com.silvershield.ssc.repos;

import com.silvershield.ssc.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
