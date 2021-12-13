package service;

import java.util.List;

import model.Reconcilation_Rule;


public interface Rservice {
		
	public boolean saveRule(Reconcilation_Rule reconcilation_rule);
	public List<Reconcilation_Rule> getRule();
	public boolean deleteRule(Reconcilation_Rule reconcilation_rule);
	public List<Reconcilation_Rule> getRuleName(Reconcilation_Rule reconcilation_rule );
	public boolean updateRule(Reconcilation_Rule reconcilation_rule);
	
}
