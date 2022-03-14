package com.abiha.springdata.hibernateinheritance;

import com.abiha.springdata.hibernateinheritance.entities.Check;
import com.abiha.springdata.hibernateinheritance.entities.CreditCard;
import com.abiha.springdata.hibernateinheritance.entities.Payment;
import com.abiha.springdata.hibernateinheritance.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HibernateInheritanceApplicationTests {

	@Autowired
	PaymentRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPayment(){

		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(1234d);
		cc.setCardnumber("1234567890");
		repository.save(cc);
	}

	@Test
	public void createCardPayment(){

		Check ch = new Check();
		ch.setId(124);
		ch.setAmount(1234d);
		ch.setChecknumber("1234567890");
		repository.save(ch);
	}










}
