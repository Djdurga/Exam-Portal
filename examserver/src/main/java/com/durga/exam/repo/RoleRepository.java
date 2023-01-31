package com.durga.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durga.exam.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	

}
