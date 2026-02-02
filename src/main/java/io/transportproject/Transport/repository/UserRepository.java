package io.transportproject.Transport.repository;

import io.transportproject.Transport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
}
