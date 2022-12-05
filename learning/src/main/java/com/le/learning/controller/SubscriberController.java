package com.le.learning.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.le.learning.exception.NotFoundException;
import com.le.learning.model.Subscriber;

@Controller
public class SubscriberController {

	@GetMapping("/testException")
	public @ResponseBody List<Subscriber> checkException() throws NotFoundException {
//		List<Subscriber> l = new ArrayList<>();
//		l.add(new Subscriber());
//		if (!l.isEmpty())
			throw new NotFoundException("Not Found Exception Occured.");
//		return l;
	}

}
