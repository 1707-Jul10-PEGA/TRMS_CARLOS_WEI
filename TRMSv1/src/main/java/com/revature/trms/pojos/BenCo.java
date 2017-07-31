package com.revature.trms.pojos;

import com.revature.trms.dao.DAOManager;
import com.revature.trms.interfaces.Approvers;

public class BenCo extends User implements Approvers{
    public BenCo(){}
    public BenCo(User user){
	this.setUserid(user.getUserid());
	this.setFirstname(user.getFirstname());
	this.setLastname(user.getLastname());
	this.setEmail(user.getEmail());
	this.setDepartment(user.getDepartment());
	this.setSupervisor(user.getSupervisor());
	this.setPosition(user.getPosition());
	this.setReimbursementTotal(user.getReimbursementTotal());
    }
    
    @Override
    public int approve(Form form) {
	return DAOManager.getApproverDAO().approveForm(this, form);
    }

    @Override
    public int deny(Form form) {
	return DAOManager.getApproverDAO().denyForm(this, form);
    }
    
    public static void main(String[] args) {
	BenCo benCo = new BenCo(DAOManager.getUserDAO().getUser(4));
	Form form = DAOManager.getReimbursementDAO().getForm(2);
	System.out.println(form);
	System.out.println(benCo.deny(form));
	System.out.println(DAOManager.getReimbursementDAO().getFormList());
    }
}
