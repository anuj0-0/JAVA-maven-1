package jdbc_maven;

import java.util.Scanner;

public class DAODriver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DAO dao = new DAO();
		boolean flag = true;
		while (flag) {
			System.out.println("1.INSERT\n2.UPDATE\n3.DELETE\n4.GET\n5.EXIT");
			int ch = s.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter id");
				int id = s.nextInt();
				System.out.println("Enter Name");
				String name = s.next();
				System.out.println("Enter Address");
				String address = s.next();
				System.out.println("Enter phone");
				long phone = s.nextLong();
				System.out.println("Enter pincode");
				int pin = s.nextInt();
				String res = dao.savePerson(id, name, address, phone, pin);
				System.out.println(res);
				break;
			case 2:
				System.out.println("Enter id");
				id = s.nextInt();
				System.out.println("Enter Name");
				name = s.next();
				System.out.println("Enter Address");
				address = s.next();
				System.out.println("Enter phone");
				phone = s.nextLong();
				System.out.println("Enter pincode");
				pin = s.nextInt();
				res = dao.updatePerson(id, name, address, phone, pin);
				System.out.println(res);
				break;
			case 3:
				System.out.println("Enter id");
				id = s.nextInt();
				res=dao.deletePerson(id);
				System.out.println(res);
				break;
			case 4: 
				System.out.println("Enter id ");
				id=s.nextInt();
				dao.getPerson(id);
				break;
			case 5:
				flag = false;
				break;
			}

		}
	}

}
