package com.example.cnpm.main;

import com.example.cnpm.main.frame.LoginForm;
import com.example.cnpm.operation.State;

public class Main {

	private static State state;
	
	public static void main(String[] args) {
		
		state = State.NEED_LOG_IN;
		
		LoginForm login = new LoginForm();
		
		
	}
}
