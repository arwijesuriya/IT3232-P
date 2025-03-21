package lk.ac.vau.fas.ict.controller;

import org.springframework.*;

@RestController
@RequestMapping("app")
public class AppController {
	
	@GetMapping("/msg")
	public String MyMessage() {
		return "Hello, this is message";
	}
	
	@GetMapping("/name")
	public String MyName() {
		return "Hello, this is name";
	}
}
