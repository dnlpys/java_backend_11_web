package test.com.fileupload.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TestVO {
	
	private int num;
	private String name;
	private int age;
	private String saveName;
	private MultipartFile multipartFile;

}
