package com.exp.self.medbook.repository;

import com.exp.self.medbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposutory extends JpaRepository<User, Long> {

}
