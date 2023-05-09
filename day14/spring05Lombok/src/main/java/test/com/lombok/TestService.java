package test.com.lombok;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestService {


	
	public TestService() {
		log.info("TestService()...");
	}
	
}
