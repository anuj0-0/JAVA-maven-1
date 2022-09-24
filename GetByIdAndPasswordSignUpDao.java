package com.ty.dao;

import java.util.Scanner;

import com.ty.dto.SignUp;

public class GetByIdAndPasswordSignUpDao {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SignUpDao pd = new SignUpDao();
		System.out.println("Enter email");
		String email = s.next();
		System.out.println("Enter password");
		String password = s.next();
		SignUp signUp = pd.getByUsernameAndPassword(email, password);
		if(signUp!=null) {
		System.out.println("Welcome"+signUp.getFirstName());
		}else {
			System.out.println("invalid");
		}
	}

}
