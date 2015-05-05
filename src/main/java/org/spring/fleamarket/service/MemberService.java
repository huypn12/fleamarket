package org.spring.fleamarket.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.spring.fleamarket.dao.MemberDao;
import org.spring.fleamarket.model.Member;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
@SuppressWarnings("unchecked")
@Transactional
public class MemberService implements MemberDao{

	private static final String MEMBER_REGION = "member";

	@PersistenceContext(unitName="MemberService")
	private EntityManager em;

	public Member createMemberByAttributes(String email, String password, String name,
			String phoneNumber, int status, Date signupDate, String cardNumber,
			Date cardExpires) {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(password);
		member.setName(name);
		member.setPhoneNumber(phoneNumber);
		member.setStatus(status);
		member.setSignupDate(signupDate);
		member.setCardNumber(cardNumber);
		member.setCardExpires(cardExpires);
		member.setTotalRating(0);
		member.setTotalFeedback(0);
		em.persist(member);
		return member;
	}

	public Member createMember(Member member) {
		if (em == null)
			System.out.println("em NULLL");
		em.persist(member);
		return member;
	}

	public Collection<Member> search(String name) {
		String sqlName = ("%" + name + "%").toLowerCase();
		String sql = "select c.* " + "from Member c "
				+ "where (LOWER( c.name ) LIKE :fn";
		return em.createNativeQuery(sql, Member.class)
				.setParameter("fn", sqlName).getResultList();
	}

	@Transactional(readOnly = true)
	public List<Member> getAllMembers() {
		return em.createQuery("SELECT * FROM " + Member.class.getName())
				.getResultList();
	}

	@Cacheable(MEMBER_REGION)
	@Transactional(readOnly = true)
	public Member getMemberById(Integer id) {
		return em.find(Member.class, id);
	}

	@Cacheable(MEMBER_REGION)
	@Transactional(readOnly = true)
	public Member getMemberByEmail(String email) {
		return em.find(Member.class, email);
	}

	@CacheEvict(MEMBER_REGION)
	public void deleteMember(Integer id) {
		Member Member = getMemberById(id);
		em.remove(Member);
	}

	@Override
	public Member getMemberByEmail(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberByName(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @CacheEvict(value = MEMBER_REGION, key = "#id") public void
	 * updateMember(Integer id, String fn, String ln, Date birthday) { Member
	 * Member = getMemberById(id); Member.setLastName(ln);
	 * Member.setSignupDate(birthday); Member.setFirstName(fn);
	 * //sessionFactory.getCurrentSession().update(Member); em.merge(Member); }
	 */

}
