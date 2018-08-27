package com.huiliang.salessituationservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import util.JWTUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesSituationServiceApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void JWTTest(){
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW5pc3RyYXRvciIsImV4cCI6MTUzNTM1MzAwOSwidXNlcm5hbWUiOiLpu47nq57osaoifQ.x6bVfz_UNlrlVCd2wtfFkgW_uz62gCwNCc6t6fK5tn8";
		System.out.println(JWTUtil.getUserName(token)+JWTUtil.getRole(token));
	}

}
