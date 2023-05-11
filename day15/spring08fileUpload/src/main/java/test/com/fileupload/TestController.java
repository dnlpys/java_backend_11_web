package test.com.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.fileupload.model.TestVO;
import test.com.fileupload.service.TestService;

@Controller
@Slf4j
public class TestController {
	
	
	@Autowired
	ServletContext sContext;
	
	@Autowired
	TestService service;
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		log.info("/insert.do");
		
		return "insert";
	}
	
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll() {
		log.info("/selectAll.do");
		
		List<TestVO> vos = service.selectAll();
		log.info("{}",vos);
		
		return "selectAll";
	}

	//fileupload>> enctype="multipart/form-data" << POST
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(TestVO vo) throws IllegalStateException, IOException {
		log.info("/insertOK.do");
		log.info("{}",vo);

		String getOriginalFilename = vo.getMultipartFile().getOriginalFilename();
		int fileNameLength = vo.getMultipartFile().getOriginalFilename().length();
		log.info("getOriginalFilename:{}",getOriginalFilename);
		log.info("fileNameLength:{}",fileNameLength);
		
		if(getOriginalFilename.length()==0) {
			vo.setSaveName("black_car.png");
		}else {
			vo.setSaveName(getOriginalFilename);
			//웹 어플리케이션이 갖는 실제 경로: 이미지를 업로드할 대상 경로를 찾아서 파일저장.
			String realPath = sContext.getRealPath("resources/uploadimg");
			log.info("realPath : {}",realPath);
			
			File f = new File(realPath+"\\"+vo.getSaveName());
			vo.getMultipartFile().transferTo(f);
		}
		log.info("{}",vo);
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		
		return "redirect:selectAll.do";
	}
	
}
