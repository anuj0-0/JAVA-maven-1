package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDao;
import com.ty.dto.SignUp;

public class GetSignUp {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SignUpDao pd = new SignUpDao();
		System.out.println("Enter email");
		String email = s.next();
		SignUp l = pd.getUser(email);
		System.out.println(l);
		
	}
}
