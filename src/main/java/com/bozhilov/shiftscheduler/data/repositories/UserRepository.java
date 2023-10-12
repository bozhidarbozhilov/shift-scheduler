package com.bozhilov.shiftscheduler.data.repositories;

import com.bozhilov.shiftscheduler.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
