package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDao;
import com.ty.dto.SignUp;

public class UpdateSignUp {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SignUpDao pd = new SignUpDao();
		SignUp c = new SignUp();
		System.out.println("Enter First name");
		c.setFirstName(s.next());
		System.out.println("Enter last name");
		c.setLastName(s.next());
		System.out.println("Enter email");
		c.setEmail(s.next());
		System.out.println("Enter password");
		c.setPassword(s.next());
		System.out.println("Enter phone");
		c.setPhone(s.nextLong());
		System.out.println("Enter date of birth");
		c.setDob(s.next());
		System.out.println("Enter gender");
		c.setGender(s.next());
		String res = pd.updateUser(c);
		System.out.println(res);
	}

}
