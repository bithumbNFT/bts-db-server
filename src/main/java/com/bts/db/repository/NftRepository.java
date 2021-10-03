package com.bts.db.repository;

import com.bts.db.domain.NFT;
import com.bts.db.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NftRepository extends JpaRepository<NFT,Long> {
    List<NFT> findByuserId(User id);
    List<NFT> findById(String id);
}
