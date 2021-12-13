package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.RdaoImp;
import model.Reconcilation_Rule;

@Service
@Transactional
public class RserviceImp implements Rservice{
	
	@Autowired
	private RdaoImp rdao;
	@Override
	public boolean saveRule(Reconcilation_Rule reconcilation_rule) {
		
		return rdao.saveRule(reconcilation_rule);
		
	}

	@Override
	public List<Reconcilation_Rule> getRule() {
		
		return rdao.getRule();
	
	}

	@Override
	public boolean deleteRule(Reconcilation_Rule reconcilation_rule) {
		
		return rdao.deleteRule(reconcilation_rule);
		
	}

	@Override
	public List<Reconcilation_Rule>getRuleName(Reconcilation_Rule reconcilation_rule) {
				
		return rdao.getRuleName(reconcilation_rule);
	}

	@Override
	public boolean updateRule(Reconcilation_Rule reconcilation_rule) {
		
		return rdao.updateRule(reconcilation_rule);
	}

}
