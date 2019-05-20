package br.usjt.plataforma.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.plataforma.model.bean.Figura;
import br.usjt.plataforma.service.UploadService;

@RestController
public class UploadController {
	
	@Autowired
	private UploadService uploadService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
			
		JSONObject json = new JSONObject();
		
		try {
			
			json = this.uploadService.upload(file);
			
			return new ResponseEntity<Object>(json.toString(), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			//json.put("erro", e.getMessage());
			
			return new ResponseEntity<Object>(json.toString(), HttpStatus.BAD_REQUEST);			
			
		}	

	}

}
