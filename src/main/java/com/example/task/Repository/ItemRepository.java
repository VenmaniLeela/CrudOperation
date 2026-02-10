package com.example.task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
