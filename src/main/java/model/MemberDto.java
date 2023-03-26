package model;

public class MemberDto {
	private String user_id;
	private String user_name;
	private String user_password;
	private String email_id;
	private String email_domain;
	
	public MemberDto() {
		super();
	}

	public String getUser_id() {
		return user_id;
	}

	// 회원가입 | 회원정보 조회 | 회원정보 수정 
	//Constructor : 아이디, 이름, 비번, 이메일 id, 이메일 domain
	public MemberDto(String user_id, String user_name, String user_password, String email_id, String email_domain) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.email_id = email_id;
		this.email_domain = email_domain;
	}
	
	
	// 로그인
	// Constructor : 아이디, 비번 
	public MemberDto(String user_id, String user_password) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmail_domain() {
		return email_domain;
	}

	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}
	
	
}
