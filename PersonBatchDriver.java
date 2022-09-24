package jdbc_maven;

import java.util.ArrayList;
import java.util.List;

public class PersonBatchDriver {
	public static void main(String[] args) {
		List<Person> l=new ArrayList();
		Person p=new Person(3,"Ram","Blr",789546,12);
		Person p1=new Person(4,"Ramesh","mub",852147,13);
		Person p2=new Person(5,"Ramu","TN",45852,14);
		Person p3=new Person(7,"Sam","KK",985245,15);
		Person p4=new Person(8,"samesh","GOA",4658726,16);
		l.add(p);
		l.add(p1);
		l.add(p2);
		l.add(p3);
		l.add(p4);
		PersonBatch pb=new PersonBatch();
		pb.insertPerson(l) ;
	}

}
