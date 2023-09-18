package com.example.workflow;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AssignPermissionHandler implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		int responseCode = 200;
		Map<String, Integer> map=new HashMap<>();
		map.put("response_code", responseCode);
		execution.setVariables(map);
		if(responseCode==200) {
			System.out.println("Permission Assigned !");
		}else {
			System.out.println("Permission Failed ! Compensation started.");
		}
	}
	
}
