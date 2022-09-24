package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignUpDao;

public class DeleteSignUp {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SignUpDao pd = new SignUpDao();
		System.out.println("Enter email");
		String email = s.next();
		String res = pd.deleteUser(email);
		System.out.println(res);
	}
}
