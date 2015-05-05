package org.spring.fleamarket.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.spring.fleamarket.model.Member;

public interface MemberDao {
	/**
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param phoneNumber
	 * @param status
	 * @param signupDate
	 * @param cardNumber
	 * @param cardExpires
	 * @return
	 */
	public Member createMemberByAttributes(String email, String password, 
			String name, String phoneNumber, int status, Date signupDate, String cardNumber,
			Date cardExpires);
	
	/**
	 * 
	 * @param member
	 * @return
	 */
	public Member createMember(Member member);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Collection<Member> search(String name);

	/**
	 * 
	 * @return
	 */
	public List<Member> getAllMembers();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Member getMemberById(Integer id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Member getMemberByEmail(Integer id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Member getMemberByName(Integer id);
	
}
