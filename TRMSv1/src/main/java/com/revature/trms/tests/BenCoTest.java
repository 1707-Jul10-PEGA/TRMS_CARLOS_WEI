package com.revature.trms.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.trms.dao.DAOManager;
import com.revature.trms.pojos.Form;
import com.revature.trms.pojos.User;
import com.revature.trms.pojos.BenCo;
import com.revature.trms.pojos.Employee;

public class BenCoTest {

    private static Form form;
    private static BenCo benCo;
    
    @BeforeClass
    public static void setup(){
	benCo = new BenCo(DAOManager.getUserDAO().getUser(4));
	form = DAOManager.getReimbursementDAO().getForm(1);
	
    }
    
    @Test
    public void approveTest() {
	assertTrue(1 == benCo.approve(form));
    }
    
    @Test
    public void denyTest() {
	assertTrue(1 == benCo.deny(form));
    }

}
