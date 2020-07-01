package com.nextgenglobal.palindrome.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome, Long>{

}
