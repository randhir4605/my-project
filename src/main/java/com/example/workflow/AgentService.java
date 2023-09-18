package com.example.workflow;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AgentService{
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	RepositoryService repositoryService;
	
	
	public Agent createAgent(Agent agent) throws Exception{
			
		DeploymentBuilder builder = repositoryService.createDeployment();
		Deployment deployment = builder.addClasspathResource("process.bpmn").deploy();
		System.out.println("process deployed with id - "+deployment.getId());
	    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	    RuntimeService runtimeService=processEngine.getRuntimeService();
	    ProcessInstance processInstance;
	    try {
	    	System.out.println("Process is going to start !!");
	    	processInstance = runtimeService.startProcessInstanceByKey("process_1");
	    	
	    }catch(ProcessEngineException ex) {
	    	System.out.println(ex.getMessage());
	    	processInstance = runtimeService.createProcessInstanceByKey("process_1").execute();
	    	System.out.println("Process Instance created !");
	    }
	    System.out.println("process instance id - " + processInstance.getProcessInstanceId());
	    
	    return agentRepository.save(agent);
	}
}
