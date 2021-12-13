package dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Reconcilation_Rule;
import model.Rule_Condition;


@Repository
public class RdaoImp {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean saveRule(Reconcilation_Rule reconcilation_rule) {
		
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(reconcilation_rule);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	public List<Reconcilation_Rule> getRule() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Reconcilation_Rule> query=currentSession.createQuery("from Reconcilation_Rule", Reconcilation_Rule.class);
		List<Reconcilation_Rule> list=query.getResultList();
		
		for(Reconcilation_Rule rule:list) {
			rule=findByKey(rule.getId(),currentSession);
		}
		
		return list;
	}
	
	public Reconcilation_Rule findByKey(int id,Session session)
	{
		Reconcilation_Rule result = (Reconcilation_Rule) session.find(Reconcilation_Rule.class, id);
	    Hibernate.initialize(result.getRuleConditions());
	    return result;
	}
	
	public boolean deleteRule(Reconcilation_Rule reconcilation_rule1 )  {
		
		Reconcilation_Rule temprule=new Reconcilation_Rule();
		
		temprule.setRuleName(reconcilation_rule1.getRuleName());
		
		List<Reconcilation_Rule> temp= getRuleName(temprule);
		
		if(temp.size()>0) {
			
			reconcilation_rule1.setId(temp.get(0).getId());
			reconcilation_rule1.setRuleConditions(temp.get(0).getRuleConditions());
			int index=0;
			for(Rule_Condition temp_rules_condition:temp.get(0).getRuleConditions()) {
				reconcilation_rule1.getRuleConditions().get(index).setId(temp_rules_condition.getId());
				index++;
			}
		}
		
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(reconcilation_rule1);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public List<Reconcilation_Rule> getRuleName(Reconcilation_Rule reconcilation_rule) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Reconcilation_Rule> query=currentSession.createQuery("from Reconcilation_Rule where ruleName=:ruleName", Reconcilation_Rule.class);
		query.setParameter("ruleName", reconcilation_rule.getRuleName());
		List<Reconcilation_Rule> list=query.getResultList();
		for(Reconcilation_Rule rule:list) {
			rule=findByKey(rule.getId(),currentSession);
		}
		currentSession.clear();
		return list;
	}
	
	
	
	public boolean updateRule(Reconcilation_Rule reconcilation_rule1) {
		
		Reconcilation_Rule temprule=new Reconcilation_Rule();
		
		temprule.setRuleName(reconcilation_rule1.getRuleName());
		
		List<Reconcilation_Rule> temp= getRuleName(temprule);
		
		if(temp.size()>0) {
		
			reconcilation_rule1.setId(temp.get(0).getId());
			int index=0;
			for(Rule_Condition temp_rules_condition:temp.get(0).getRuleConditions()) {
				reconcilation_rule1.getRuleConditions().get(index).setId(temp_rules_condition.getId());
				index++;
			}
		}
		

		
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(reconcilation_rule1);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


}
