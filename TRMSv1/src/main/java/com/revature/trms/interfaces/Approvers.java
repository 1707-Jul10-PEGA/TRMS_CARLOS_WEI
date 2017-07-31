package com.revature.trms.interfaces;

import com.revature.trms.pojos.Form;

public interface Approvers {

    public int approve(Form form);
    
    public int deny(Form form);
}
