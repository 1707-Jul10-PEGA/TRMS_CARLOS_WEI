package com.revature.trms.test;

import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.trms.util.ConnectionFactory;

public class ConnectionFactoryTest {
	@Test
    public void connectionTest() {
	Connection conn = ConnectionFactory.getInstance().getConnection();
	try {
	    assertFalse(conn.isClosed());
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
