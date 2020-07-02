package com.nextgenglobal.palindrome.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome, Long>{

	@Query("Select p from Palindrome p where p.name like %:name%")
	List<Palindrome> findByNameContaining(@Param("name") String name);
}
