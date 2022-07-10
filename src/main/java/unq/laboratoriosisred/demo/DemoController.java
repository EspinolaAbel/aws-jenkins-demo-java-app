package unq.laboratoriosisred.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("ping")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("hola mundo");
	}

}
