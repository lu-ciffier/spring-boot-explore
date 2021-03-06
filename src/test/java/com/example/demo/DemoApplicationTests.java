package com.example.demo;

import com.lucifer.config.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private RabbitSender rabbitSender;

	@Test
	public void hello() throws Exception {
		rabbitSender.send();
	}

}
