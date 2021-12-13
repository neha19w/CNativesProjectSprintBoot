package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Reconcilation_Rule;
import service.Rservice;


@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping(value="/api")
public class Controller {
		
	
	@Autowired
	private Rservice rservice;
	
	@PostMapping("save-rule")
	public boolean saveItem(@RequestBody Reconcilation_Rule reconcilation_rule) {
		 return rservice.saveRule(reconcilation_rule);
		
	}
	@GetMapping("rule-list")
	public List<Reconcilation_Rule> allrule() {
				 return rservice.getRule();
	}
	
	
	@DeleteMapping("delete-rule/{ruleName}")
	public boolean deleteRule(@PathVariable("ruleName") String ruleName,Reconcilation_Rule reconcilation_rule) {
		reconcilation_rule.setRuleName(ruleName);
		return rservice.deleteRule(reconcilation_rule);
	}

	
	@GetMapping("rule/{ruleName}")
	public List<Reconcilation_Rule> allrulebyruleName(@PathVariable("ruleName") String ruleName,Reconcilation_Rule reconcilation_rule) {
		reconcilation_rule.setRuleName(ruleName);

		List<Reconcilation_Rule> local=rservice.getRuleName(reconcilation_rule);	
		 return local;
		
	}
	
	@PutMapping("update-rule/{ruleName}")
	public boolean updateRule(@RequestBody Reconcilation_Rule reconcilation_rule,@PathVariable("ruleName") String ruleName) {
		reconcilation_rule.setRuleName(ruleName);
		return rservice.updateRule(reconcilation_rule);	
	}
	
	
}
