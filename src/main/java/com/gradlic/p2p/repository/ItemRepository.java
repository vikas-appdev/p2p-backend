package com.gradlic.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradlic.p2p.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
