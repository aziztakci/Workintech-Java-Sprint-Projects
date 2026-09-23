package com.workintech.s19d2.repository;

import com.workintech.s19d2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("SELECT a FROM Role a WHERE a.authority=:authority")
    Optional<Role> findByAuthority(@Param("authority")String authority);


}
