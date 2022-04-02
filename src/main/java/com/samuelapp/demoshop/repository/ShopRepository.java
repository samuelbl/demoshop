package com.samuelapp.demoshop.repository;

import com.samuelapp.demoshop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Integer> {

}
