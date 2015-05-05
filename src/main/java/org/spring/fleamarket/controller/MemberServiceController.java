package org.spring.fleamarket.controller;

import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.spring.fleamarket.model.Member;
import org.spring.fleamarket.service.MemberService;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberServiceController {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	private Jaxb2Marshaller jaxb2Marshaller;

	public void setJaxb2Marshaller(Jaxb2Marshaller jaxb2Marshaller) {
		this.jaxb2Marshaller = jaxb2Marshaller;
	}
	
	private static final String XML_VIEW_NAME = "member";
	
	/**
	 * Member signup
	 */
	@RequestMapping(value="/signup", 
			method=RequestMethod.POST)
	public @ResponseBody Member addMember(@RequestBody String body) {
		
		Source source = null;
		try {
			source = new StreamSource(new StringReader(body));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Member m = null;
		try {
			m = (Member) jaxb2Marshaller.unmarshal(source);
			memberService.createMember(m);
			System.out.println(m.toString());
		} catch (XmlMappingException e) {
			e.printStackTrace();
		}
		
		// TODO
		return m;
		
	}
	
	/**
	 * Member signin
	 */
	@RequestMapping(value="/signin/", 
			method=RequestMethod.GET)
	public @ResponseBody String signinMember(@RequestBody String body) {
		
		Member m = memberService.getMemberByEmail(body);
		
		if (m != null)
			return "OK";
		else
			return "Failed";
	}
}
