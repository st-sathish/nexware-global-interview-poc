package com.nextgenglobal.palindrome.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.nextgenglobal.palindrome.form.PalindromeForm;

@Entity(name = "Palindrome")
@Table(name = "palindrome", uniqueConstraints={@UniqueConstraint(columnNames={"list"})})
public final class Palindrome {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "list")
	private String name;
	
	public Palindrome() {
		
	}
	
	public Palindrome(final String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public static Palindrome from(final PalindromeForm form) {
		final Palindrome palindrome = new Palindrome();
		palindrome.setName(form.getName());
		return palindrome;
	}
	
}
