package jdbc_maven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAODriver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Product> l = new ArrayList();
		ProductDAO pd = new ProductDAO();
		boolean flag = true;
		while (flag) {
			System.out.println("0.batchInsertion\n1.Insert\n2.Update\n3.Delete\n4.Get\n5.GetAll\n6.Exit");
			int ch = s.nextInt();
			switch (ch) {
			case 0:
				int i = 1;
				boolean condition = true;
				while (condition) {

					System.out.println("1.Insert\n2.Exit to main menu");
					int c = s.nextInt();
					switch (c) {
					case 1:
						Product p = new Product();
						System.out.println("Product " + i);
						System.out.println("Enter id");
						p.setId(s.nextInt());
						System.out.println("Enter name");
						p.setName(s.next());
						System.out.println("Enter price");
						p.setPrice(s.nextDouble());
						System.out.println("Enter manufactuer");
						p.setManufacturer(s.next());
						System.out.println("Enter discount");
						p.setDiscount(s.nextDouble());
						System.out.println("Enter warranty");
						p.setWarranty(s.nextInt());
						s.nextLine();
						System.out.println("Enter manufacter date");
						p.setManufaterDate(s.nextLine());
						System.out.println("Enter gst");
						p.setGst(s.nextInt());
						l.add(p);
						i++;
						break;
					case 2:
						condition = false;
						break;
					}

				}
				String res = pd.saveProduct(l);
				System.out.println(res);
				break;
			case 1:
				Product po = new Product();
				System.out.println("Enter id");
				po.setId(s.nextInt());
				System.out.println("Enter name");
				po.setName(s.next());
				System.out.println("Enter price");
				po.setPrice(s.nextDouble());
				System.out.println("Enter manufactuer");
				po.setManufacturer(s.next());
				System.out.println("Enter discount");
				po.setDiscount(s.nextDouble());
				System.out.println("Enter warranty");
				po.setWarranty(s.nextInt());
				s.nextLine();
				System.out.println("Enter manufacter date");
				po.setManufaterDate(s.nextLine());
				System.out.println("Enter gst");
				po.setGst(s.nextInt());
				pd.saveProduct(po);
				break;
			case 2:
				Product p = new Product();
				System.out.println("Enter id");
				p.setId(s.nextInt());
				System.out.println("Enter name");
				p.setName(s.next());
				System.out.println("Enter price");
				p.setPrice(s.nextDouble());
				System.out.println("Enter manufactuer");
				p.setManufacturer(s.next());
				System.out.println("Enter discount");
				p.setDiscount(s.nextDouble());
				System.out.println("Enter warranty");
				p.setWarranty(s.nextInt());
				s.nextLine();
				System.out.println("Enter manufacter date");
				p.setManufaterDate(s.nextLine());
				System.out.println("Enter gst");
				p.setGst(s.nextInt());
				res = pd.updatePerson(p);
				System.out.println(res);

				break;
			case 3:
				Product p1 = new Product();
				System.out.println("Enter id");
				p1.setId(s.nextInt());
				res = pd.deleteProduct(p1);
				System.out.println(res);
				break;
			case 4:
				Product p2 = new Product();
				System.out.println("Enter id");
				p2.setId(s.nextInt());
				Product pr = pd.getProduct(p2);
				System.out.println("*******************************************************");
				System.out.println(pr);
				System.out.println("*******************************************************");
				break;
			case 5:
				List<Product> list = pd.getProduct();
				for(Product k:list) {
					System.out.println(k);
				}
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("invalid input");
			}
		}

	}

}
