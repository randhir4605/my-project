package com.example.workflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	AgentService agentService;
	
	@PostMapping("/agent")
	public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) throws Exception{
		agent = agentService.createAgent(agent);
		return new ResponseEntity<>(agent, HttpStatus.OK);
	}
}
