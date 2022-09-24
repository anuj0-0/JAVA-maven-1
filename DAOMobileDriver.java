package jdbc_maven;

import java.util.Scanner;

public class DAOMobileDriver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Mobile m = new Mobile();
		DAOMobile dm = new DAOMobile();
		boolean flag = true;
		System.out.println("1.Insert \n2.update\n3.delete\n4.get\n5.exit");
		int ch = s.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter id");
			m.setId(s.nextInt());
			System.out.println("Enter name");
			m.setName(s.next());
			System.out.println("Enter brand");
			m.setBrand(s.next());
			System.out.println("Enter colour");
			m.setColour(s.next());
			System.out.println("Enter price");
			m.setPrice(s.nextDouble());
			System.out.println("Enter ram");
			m.setRam(s.nextInt());
			System.out.println("Enter camera");
			m.setRam(s.nextInt());
			String res = dm.insertMobile(m);
			System.out.println(res);
			break;

		case 2:
			System.out.println("Enter id");
			m.setId(s.nextInt());
			System.out.println("Enter name");
			m.setName(s.next());
			System.out.println("Enter brand");
			m.setBrand(s.next());
			System.out.println("Enter colour");
			m.setColour(s.next());
			System.out.println("Enter price");
			m.setPrice(s.nextDouble());
			System.out.println("Enter ram");
			m.setRam(s.nextInt());
			System.out.println("Enter camera");
			m.setRam(s.nextInt());
			res = dm.updateMobile(m);
			System.out.println(res);
			break;
		case 3:
			System.out.println("Enter id");
			m.setId(s.nextInt());
			res=dm.deleteMobile(m);
			System.out.println(res);
			break;
		case 4:
			System.out.println("Enter id");
			m.setId(s.nextInt());
			Mobile m1=dm.getMobile(m);
			System.out.println(m1);
			break;
			
		case 5: flag=false;
		break;
			
			
			
		}

	}

}
