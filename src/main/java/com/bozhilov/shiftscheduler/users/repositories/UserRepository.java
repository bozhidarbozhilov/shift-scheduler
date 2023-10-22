package com.bozhilov.shiftscheduler.users.repositories;

import com.bozhilov.shiftscheduler.users.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
