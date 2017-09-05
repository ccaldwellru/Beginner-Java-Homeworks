/*
*	Password.java will let the user create a password as long
*	as it meets the criteria that is presented to them.
*	If it does not meet the criteria then the program will 
*	let the user know what is wrong and how to fix it.
*
*	@author Corey Caldwell
*	@version 2/21/16
*/

import java.util.Scanner;

public class Password {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String userPassword;
		Boolean done = false;
		Boolean uppercase = false;
		Boolean number = false;
		Boolean symbol = false;
		int pos = 0;
		System.out.print("Password must be at least 8 characters but less than 16 characters"
				+ "\nPassword must have at least one uppercase character\nPassword must have at least one number\n"
				+ "Password must have at least one special character\n");
		while (done == false) {
			System.out.print("Please enter a password: ");
			userPassword = scan.nextLine();

			if (userPassword.length() >= 8 && userPassword.length() <= 16) {
				uppercase = false;
				pos = 0;
				while (uppercase == false) {
					if (userPassword.charAt(pos) >= 'A' && userPassword.charAt(pos) <= 'Z') {
						uppercase = true;
						pos = 0;
						number = false;
						while (number == false) {
							if (userPassword.charAt(pos) >= '0' && userPassword.charAt(pos) <= '9') {
								number = true;
								pos = 0;
								symbol = false;
								while (symbol == false) {
									if ((userPassword.charAt(pos) >= '!' && userPassword.charAt(pos) <= '/')
											|| (userPassword.charAt(pos) >= ':' && userPassword.charAt(pos) <= '@')
											|| (userPassword.charAt(pos) >= '[' && userPassword.charAt(pos) <= '`')
											|| (userPassword.charAt(pos) >= '{' && userPassword.charAt(pos) <= '~')) {
										symbol = true;
										System.out.println("Password is good!");
										done = true;
									} else if (pos >= userPassword.length() - 1) {
										System.out.println("\nPassword must contain a symbol.\n");
										symbol = true;
										done = false;
									} else {
										pos++;
									}
								}
							} else if (pos >= userPassword.length() - 1) {
								System.out.println("\nPassword must contain a number.\n");
								number = true;
								done = false;
							} else {
								pos++;
							}
						}
					} else if (pos >= userPassword.length() - 1) {
						System.out.println("\nPassword must contain an uppercase letter.\n");
						uppercase = true;
						done = false;
					} else {
						pos++;
					}
				}
			} else if (userPassword.length() < 8) {
				System.out.println("\nPassword is too short it must be between 8 and 16 characters.\n");
				done = false;
			} else {
				System.out.println("\nPassword is too long it must be between 8 and 16 characters.\n");
				done = false;
			}
		}
	}
}
