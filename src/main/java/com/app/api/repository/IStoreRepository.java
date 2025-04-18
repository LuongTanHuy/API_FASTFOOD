package com.app.api.repository;

import com.app.api.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStoreRepository extends JpaRepository<Store,Integer> {
    @Query("SELECT a FROM Store a WHERE a.name LIKE %:keyword% OR a.email LIKE %:keyword% OR a.phone LIKE %:keyword% OR a.address LIKE %:keyword%")
    List<Store> findByKeyword(@Param("keyword") String keyword);
    @Query("SELECT a FROM Store a WHERE a.status < 2 ORDER BY a.created_at DESC ")
    List<Store> getStoreByTime();

    @Query("SELECT a FROM Store a WHERE a.status = 2 ORDER BY a.created_at DESC ")
    List<Store> getAllRequestOpenStore();

}
