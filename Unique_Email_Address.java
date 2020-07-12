import java.util.*;
public class Unique_Email_Address {
	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
	    System.out.println("The number of Unique Email is: "+UniqueEmail(emails));
	}
	public static int UniqueEmail(String[] emails) {
		HashSet<String>unique = new HashSet<>();
		for (String email:emails) {
			String[] add = email.split("@");
			String loc = add[0];
			String domain = add[1];
			if (loc.contains(".")) {
				loc = loc.replace(".", "");
			}
			if (loc.contains("+")) {
				int ind = loc.indexOf("+");
				loc = loc.substring(0,ind);
			}
			String newEmail = loc+"@"+domain;
			unique.add(newEmail);
		}
		return unique.size();
	}
}
