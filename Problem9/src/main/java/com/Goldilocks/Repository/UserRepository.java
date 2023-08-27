package com.Goldilocks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Goldilocks.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
}
