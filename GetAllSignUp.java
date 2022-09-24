package com.ty.controller;

import java.util.List;

import com.ty.dao.SignUpDao;
import com.ty.dto.SignUp;

public class GetAllSignUp {
	public static void main(String[] args) {
		SignUpDao pd=new SignUpDao();
		List<SignUp> l=pd.getAll();
		for(SignUp c:l) {
		System.out.println(c);
		}
	}

}
