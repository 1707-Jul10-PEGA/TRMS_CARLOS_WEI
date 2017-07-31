package com.revature.trms.pojos;

import com.revature.trms.dao.DAOManager;
import com.revature.trms.interfaces.Approvers;

public class BenCo extends User{
    public BenCo(){
	super();
    }
    
    public int approve(Form form) {
	return DAOManager.getApproverDAO().approveForm(this, form);
    }

    public int deny(Form form) {
	return DAOManager.getApproverDAO().denyForm(this, form);
    }
    
    public static void main(String[] args) {
	User benCo = DAOManager.getUserDAO().getUser(4);
	Form form = DAOManager.getReimbursementDAO().getForm(2);
	System.out.println(form);
	System.out.println(benCo);
	System.out.println(DAOManager.getReimbursementDAO().getFormList());
    }
}
