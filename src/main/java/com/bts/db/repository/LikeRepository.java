package com.bts.db.repository;

import com.bts.db.domain.Like;
import com.bts.db.domain.NFT;
import com.bts.db.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByuserId(User id);
}
