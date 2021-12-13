package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Reconcilation_Rule")
public class Reconcilation_Rule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	String ruleName;
	String ruleVersion;
	int rulePriorityId;
	Boolean isActive;
	

	@OneToMany(targetEntity=Rule_Condition.class,cascade = {CascadeType.ALL})
	List<Rule_Condition> ruleConditions;
	

	
	public List<Rule_Condition> getRuleConditions() {
		return ruleConditions;
	}
	public void setRuleConditions(List<Rule_Condition> ruleConditions) {
		this.ruleConditions = ruleConditions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleVersion() {
		return ruleVersion;
	}
	public void setRuleVersion(String ruleVersion) {
		this.ruleVersion = ruleVersion;
	}
	public int getRulePriorityId() {
		return rulePriorityId;
	}
	public void setRulePriorityId(int rulePriorityId) {
		this.rulePriorityId = rulePriorityId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	

	
}
