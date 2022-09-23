package com.mx.ieepo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ieepo.domain.Alumno;
import com.mx.ieepo.services.AlumnoService;


@RestController
@RequestMapping("alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	
	@GetMapping(value="{id}")
	public Optional<Alumno> findbyId (@PathVariable(  )Long id) {
		
		return alumnoService.findbyId(id);
	}
	@RequestMapping(value="download", method=RequestMethod.GET)
	public void getDownload(HttpServletResponse response) throws IOException {

		// Get your file stream from wherever.
		File initialFile = new File("src/main/resources/sample.txt");
		InputStream myStream = null;;
		try {
			myStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Set the content type and attachment header.
		response.addHeader("Content-disposition", "attachment;filename=myfilename.txt");
		response.setContentType("txt/plain");

		// Copy the stream to the response's output stream.
		IOUtils.copy(myStream, response.getOutputStream());
		response.flushBuffer();
	}
	
	@RequestMapping(value = "files", method = RequestMethod.GET)
	public void getFile(HttpServletResponse response) {
	    try {
	      // get your file as InputStream
	    	File initialFile = new File("/var/spa/tarjetas/regalo_fathers.png");
	      InputStream is = new FileInputStream(initialFile);
	      // copy it to response's OutputStream
	      IOUtils.copy(is, response.getOutputStream());
	      response.setContentType("image/png");
	      response.flushBuffer();
	    } catch (IOException ex) {
	    	System.out.print("error" + ex);
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	}
	
	@RequestMapping(value = "download2", method = RequestMethod.GET)
	public ResponseEntity download() throws IOException {
	    String filePath = "/var/spa/tarjetas/regalo_fathers.png";
	    InputStream inputStream = new FileInputStream(new File(filePath));
	    InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentLength(Files.size(Paths.get(filePath)));
	    return new ResponseEntity(inputStreamResource, headers, HttpStatus.OK);
	}
	
	@GetMapping(value="")
	public Iterable<Alumno> findAll () {
		return alumnoService.findAll();
	}
	
	@PostMapping(value="")
	public Alumno save (@RequestBody Alumno alumno) {
		System.out.print("ejemplo diff");
		return alumnoService.save(alumno);
	}
	
	@PutMapping(value="")
	public Alumno update (@RequestBody Alumno alumno) {
		return alumnoService.update(alumno);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable("id") Long id) {
		alumnoService.delete(id);
	}
	
	@GetMapping(value="finByProfesor/{idProfesor}")
	public List<Alumno> findbyProfesorId (@PathVariable( "idProfesor" )Long id) {
		
		return alumnoService.findbyProfesorId(id);
	}
	
	

}
