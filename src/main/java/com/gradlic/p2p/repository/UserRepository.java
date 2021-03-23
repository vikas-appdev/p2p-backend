package com.gradlic.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradlic.p2p.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
