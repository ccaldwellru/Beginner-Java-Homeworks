/**
 * StoryDriver.java - creates a wacky story from the user submitted data.
 *
 * @author Corey Caldwell
 * @version 1/31/2016
 */
import java.util.Scanner;
public class StoryDriver {
	public static void main (String args[]){
		//creates the scanner
		Scanner scan = new Scanner(System.in);
		//creates the variables to hold users input
		String femaleFriend;
		String sport;
		String verb1;
		String verb2;
		String food1;
		String food2;
		String food3;
		String femaleFriend2;
		String bodyPart;
		String noun1;
		String noun2;
		String pluralNoun;
		
		//each of the print statements asking for a specific words for the story
		System.out.print("Please enter a female friend's name: ");
		femaleFriend = scan.nextLine();
		System.out.print("Please enter a sport you play: ");
		sport = scan.nextLine();
		System.out.print("Please enter a verb ending in (ing): ");
		verb1= scan.nextLine();
		System.out.print("Please enter a verb ending in (ing): ");
		verb2 = scan.nextLine();
		System.out.print("Please enter a food (plural): ");
		food1 = scan.nextLine();
		System.out.print("Please enter a food (plural): ");
		food2 = scan.nextLine();
		System.out.print("Please enter a food (plural): ");
		food3 = scan.nextLine();
		System.out.print("Please enter a female friend's name: ");
		femaleFriend2 = scan.nextLine();
		System.out.print("Please enter a body part (singular): ");
		bodyPart = scan.nextLine();
		System.out.print("Please enter a noun (singular): ");
		noun1 = scan.nextLine();
		System.out.print("Please enter a noun (singular): ");
		noun2 = scan.nextLine();
		System.out.print("Please enter a noun (plural): ");
		pluralNoun = scan.nextLine();
		//printing out the story to the user
		System.out.println("Flying Through Lunch\n\nThis evening, " + femaleFriend + " tried out for the " + sport + " team at school. " 
				+ femaleFriend + " worked very hard,"
				+ "\n" + verb1 +" every morning and " + verb2 + " every day after school. She was sure to be a shoe-in!\n\n"
				+ "That was what we all thought until this afternoon at lunch. " + femaleFriend + " was carrying her lunch\n"
				+ "tray filled with " + food1 +", " + food2 + ", and " + food3 + ". She walked over to sit with the captain\n"
				+ "of the team, " + femaleFriend2 + ". Suddenly, " + femaleFriend + " got a terrible itch on her " + bodyPart + ". She tried to scratch it,\n"
				+ "but instead she tripped over a(n) " + noun1 + " and sent the lunch tray flying across the\n"
				+ "cafeteria, where it landed on " + femaleFriend2 + "'s " + noun2 + " and made a complete mess!\n\n"
				+ femaleFriend + " was so embarrassed. She was sure she would never make the team. What she didn't\n"
				+ "know was that a similar story happened to " + femaleFriend2 + " when she was trying out for the team.\n"
				+ femaleFriend2 + " accidentally threw " + pluralNoun + " all over the coach.\n\n"
				+ "At tryouts this evening, " + femaleFriend + " did great and " + femaleFriend2 + " personally congratulated her on\n"
				+ "becoming the newest member of the team.");
	}

}