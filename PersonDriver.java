package jdbc_maven;

import java.util.Scanner;

public class PersonDriver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DAO dao = new DAO();
		boolean flag = true;
		while (flag) {
			System.out.println("1.Insert\n2.Update\n3.Get\n4.Exit");
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
				Person p = new Person();
				p.setId(id);
				p.setName(name);
				p.setPhone(phone);
				p.setAddress(address);
				p.setPin(pin);
				String res = dao.savePerson(p);
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
				p = new Person();
				p.setId(id);
				p.setName(name);
				p.setPhone(phone);
				p.setAddress(address);
				p.setPin(pin);
				res = dao.updatePerson(p);
				System.out.println(res);
				break;

			case 3:
				System.out.println("Enter id");
				id = s.nextInt();
				Person p1 = dao.getPersonObj(id);
				System.out.println(p1);
				break;

			case 4:
				flag = false;
				break;
			}
		}

	}

}
