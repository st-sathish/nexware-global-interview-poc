package com.nextgenglobal.palindrome.data;

public final class PalindromeData {

	private String name;
	private Long id;
	
	public static PalindromeData newInstance(final Long id, final String name) {
		return new PalindromeData(id, name);
	}
	
	private PalindromeData() {
		
	}
	
	private PalindromeData(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
