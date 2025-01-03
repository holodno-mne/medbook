package com.exp.self.medbook.Repository;

import com.exp.self.medbook.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposutory extends JpaRepository<User, Long> {

}
