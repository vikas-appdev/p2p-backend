package com.gradlic.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradlic.p2p.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
