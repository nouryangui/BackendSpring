package tn.enis.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import tn.enis.member.bean.PublicationBean;
import tn.enis.member.proxy.PublicationProxy;
import tn.enis.member.service.IMemberService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MemberApplication implements CommandLineRunner {
	@Autowired
	PublicationProxy publicationProxy;
	@Autowired
	IMemberService iMemberService;

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		
	
		

	}

}