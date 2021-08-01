import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 6;
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Appointment> appList = new ArrayList<Appointment>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userList.add(new Customer("Shino", "9395-9352", "shino@gmail.com", "Customer"));
		userList.add(new Designer("Kuro", "9395-9312", "kuroRA@gmail.com", "Designer"));

		appList.add(new Appointment("Shino", "2021-05-06", 1500, "Kuro", "River Valley 2510"));

		int option = 0;
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Manage User
				C206_CaseStudy.manageUser();

			} else if (option == 2) {
				// Manage Package

			} else if (option == 3) {
				// Manage Request for quotation

			} else if (option == 4) {
				// Manage Quotation

			} else if (option == 5) {
				// Manage Appointment
				C206_CaseStudy.manageApp();

			} else if (option == 6) {
				System.out.println("Logging off. . .");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("RENOVATION ACE");
		System.out.println("1. Manage User");
		System.out.println("2. Manage Package");
		System.out.println("3. Manage Request for Quotation");
		System.out.println("4. Manage Quotation");
		System.out.println("5. Manage Appointment");
		System.out.println("6. Logout");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ---<< MANAGE USER MENU >>---// Done by: Yolanda
	public static void manageUser() {
		C206_CaseStudy.setHeader("MANAGE USER");
		System.out.println("1. Add New User");
		System.out.println("2. View All User");
		System.out.println("3. Delete User");
		System.out.println("4. Back");
		Helper.line(80, "-");

		int mUser = Helper.readInt("Enter an option > ");

		if (mUser == 1) {
			User u1 = inputUser();
			C206_CaseStudy.addUser(userList, u1);
		} else if (mUser == 2) {
			C206_CaseStudy.viewAllCustomer(userList);
			C206_CaseStudy.viewAllDesigner(userList);
		} else if (mUser == 3) {
			User u1 = C206_CaseStudy.inputDeleteUser();
			C206_CaseStudy.deleteUser(userList, u1);
		} else if (mUser > 4 || mUser < 0) {
			System.out.println("Invalid option");
		}
	}

	// ---<< MANAGE USER: ADD USER >>---// Done by: Yolanda
	public static User inputUser() {
		User u1 = null;

		while (u1 == null) {

			String name = Helper.readStringRegEx("Enter name > ", "\\D{3,}");
			String mobile = Helper.readStringRegEx("Enter mobile [0000-0000] > ", "[89]\\d{3}-\\d{4}");
			String email = Helper.readStringRegEx("Enter email > ", "^\\S+@\\S+\\.\\S+$");
			String role = Helper.readStringRegEx("Enter role > ", "\\b(Customer\\b|Client\\b|Designer)\\b");

			if (role.equalsIgnoreCase("Customer") || role.equalsIgnoreCase("Client")) {
				u1 = new Customer(name, mobile, email, role);
			} else if (role.equalsIgnoreCase("Designer")) {
				u1 = new Designer(name, mobile, email, role);
			} else {
				System.out.println("Invalid role entered.");
			}
		}

		return u1;

	}

	public static void addUser(ArrayList<User> userList, User u1) {

		if (userList.add(u1)) {
			System.out.println("User successfully added");
		}
		
	}

	// ---<< MANAGE USER: VIEW CUSTOMER >>---// Done by: Yolanda
	public static String retrieveAllCustomer(ArrayList<User> userList) {
		String output = "";

		for (User u : userList) {
			if (u instanceof Customer) {
				Customer c = (Customer) u;
				output += String.format("%-10s %-10s %-20s %-10s\n", c.getName(), c.getNumber(), c.getEmail(),
						c.getStatus());

			}
		}
		return output;
	}

	public static void viewAllCustomer(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("CLIENT LIST");
		String output = String.format("%-10s %-10s %-20s %-10s\n", "NAME", "NUMBER", "EMAIL", "STATUS");
		output += retrieveAllCustomer(userList);
		System.out.println(output);
	}

	// ---<< MANAGE USER: VIEW DESIGNER >>---// Done by: Yolanda
	public static String retrieveAllDesigner(ArrayList<User> userList) {
		String output = "";

		for (User u : userList) {
			if (u instanceof Designer) {
				Designer d = (Designer) u;
				output += String.format("%-10s %-10s %s\n", d.getName(), d.getNumber(), d.getEmail());

			}
		}
		return output;
	}

	public static void viewAllDesigner(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("DESIGNER LIST");
		String output = String.format("%-10s %-10s %s\n", "NAME", "NUMBER", "EMAIL");
		output += retrieveAllDesigner(userList);
		System.out.println(output);
	}

	// ---<< MANAGE USER: DELETE USER >>---// Done by: Yolanda
	public static User inputDeleteUser() {
		if (userList.size() != 0) {
			String name = Helper.readString("Enter name > ");
			for (User u : userList) {
				if (u.getName().equals(name)) {
					return u;
				}
			}
		}
		return null;
	}

	public static void deleteUser(ArrayList<User> userList, User u1) {
		if (userList.remove(u1)) {
			System.out.println("User successfully deleted");
		} else {
			System.out.println("Invalid user");
		}
	}

	// ---<< MANAGE APPOINTMNET MENU >>---// Done by: Yolanda
	public static void manageApp() {
		C206_CaseStudy.setHeader("MANAGE APPOINTMENT");
		System.out.println("1. Add New Appointment");
		System.out.println("2. View All Appointment");
		System.out.println("3. Delete Appointment");
		System.out.println("4. Back");
		Helper.line(80, "-");

		int mUser = Helper.readInt("Enter an option > ");

		if (mUser == 1) {
			Appointment a1 = inputApp();
			C206_CaseStudy.addApp(appList, a1);
		} else if (mUser == 2) {
			C206_CaseStudy.viewAllAppointment(appList);

		} else if (mUser == 3) {
			Appointment a1 = C206_CaseStudy.inputDeleteApp();
			C206_CaseStudy.deleteApp(appList, a1);

		} else if (mUser > 4 || mUser < 0) {
			System.out.println("Invalid option");
		}
	}

	// ---<< MANAGE APPOINTMENT: ADD APPOINTMENT >>---// Done by: Yolanda
	public static Appointment inputApp() {
		Appointment a1 = null;

		boolean check = false;
		String name = Helper.readStringRegEx("Enter Name > ", "\\D{3,}");
		if (checkUser(name)) {
			String address = Helper.readStringRegEx("Enter Address > ", "\\D{1,}");
			String date = Helper.readStringRegEx("Enter date [yyyy-MM-dd] > ", "\\d{4}-\\d{2}-\\d{2}");
			String time = Helper.readStringRegEx("Enter time [0000] > ", "\\d{4}");
			int t2 = Integer.parseInt(time);
			while (check == false) {

				C206_CaseStudy.viewAllDesigner(userList);

				String designer = Helper.readString("Enter designer name > ");

				if (appList.size() > 0) {
					for (Appointment a : appList) {
						if (a.getDesigner().equals(designer) && a.getDate().equals(date) && a.getTime() == t2) {
							System.out.println("Designer already has an appointment on this date and time");
						} else if (!(a.getDesigner().equals(designer))) {
							check = false;
						} else if (a.getDesigner().equals(designer)) {
							a1 = new Appointment(name, date, t2, designer, address);
							check = true;
							break;
						}
					}
				}

			}
		}
		else {
			System.out.println("User not registered");
			inputApp();
		}
		return a1;
	}

	public static void addApp(ArrayList<Appointment> appList, Appointment a1) {
		if (appList.add(a1)) {
			System.out.println("Appointment successfully added");
		}
	}

	// ---<< MANAGE APPOINTMENT: VIEW APPOINTMENT >>---// Done by: Yolanda 
	public static String retrieveAllAppointment(ArrayList<Appointment> appList) {
		String output = "";

		for (Appointment a : appList) {

			output += String.format("%-10s %-10s %-10d %-10s %s\n", a.getCustName(), a.getDate(), a.getTime(),
					a.getDesigner(), a.getAddress());

		}
		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> appList) {
		C206_CaseStudy.setHeader("APPOINTMENT LIST");
		String output = String.format("%-10s %-10s %-10s %-10s %s\n", "NAME", "DATE", "TIME", "DESIGNER", "ADDRESS");
		output += retrieveAllAppointment(appList);
		System.out.println(output);
	}

	// ---<< MANAGE APPOINTMENT: DELETE APPOINTMENT >>---// Done by: Yolanda
	public static Appointment inputDeleteApp() {

		if (appList.size() != 0) {
			String name = Helper.readStringRegEx("Enter name > ", "\\D{3,}");
			if (checkUser(name)) {
				for (Appointment a : appList) {
					if (a.getCustName().equals(name)) {
						return a;
					}
				}
			}
		} else {
			System.out.println("There are no appointments");
		}
		return null;
	}

	public static void deleteApp(ArrayList<Appointment> appList, Appointment a1) {
		if (appList.remove(a1)) {
			System.out.println("Appointment successfully deleted");
		} else {
			System.out.println("Unable to delete appointment");
		}

	}

	private static boolean checkUser(String user) {
		boolean check = false;
		for (User u : userList) {
			if (u instanceof Customer) {
				Customer c = (Customer) u;
				if (c.getName().equals(user)) {
					check = true;
				} else {
					check = false;
				}
			}
		}
		return check;
	}
}
