/**************************************************
/
/   don't forget to put your name  up here in the header!
/
**************************************************/
public class HW5Srv {

//
//  takes an int array and formats it nicely as a String
//
public String makeString(int[] arr) {
	String result = "";
	for(int i = 0; i < arr.length; i++){
		result = result + " " + arr[i];
	}
    return result;
}

//
//  takes a char array and formats it nicely as a String
//
public String makeString(char[] arr) {
    String result = "";
	for(int i = 0; i < arr.length; i++){
		result = result + " " + arr[i];
	}
    return result;
}

//
//  takes a String and encodes each character in it as an int
//  and returns the int array
//
public int[] encode(String str) {
    int[] encoded = new int[str.length()];
	char [] charArray = str.toCharArray();
	for(int i = 0; i < charArray.length; i++){
		encoded[i] = charArray[i] + 32;
	}
	return encoded;
}

//
//  undoes what encode does - takes the encoded int array and returns a String 
//
public String decode(int[] arr) {
    String decoded = "";
	for(int i = 0; i < arr.length; i++){
		decoded = decoded + (char) (arr[i] - 32);
	}
	return decoded;
}

//
//  takes an array of boolean and an array of char, which are the same length
//  returns an array that contains every char that is in the same position 
//  as every true boolean in the mask array
//
public char[] filter(boolean[] mask, char[] message) {
    int counterForLength = 0;
	for(int i = 0; i < message.length; i++){
		if(mask[i] == true){
			counterForLength++;
		}
	}
	char[] array = new char[counterForLength];
	int a = 0;
	for(int i = 0; i < message.length; i++){
		if(mask[i] == true){
			array[a] = message[i];
			a++;
		}
	}
	return array;
}

//
//  takes an array of ints, msg, and array of chars, letters 
//  each int in the msg array is the position of a character in the letters array
//  returns a String of all those letters
//
public String indexMessage(int[] msg, char[] letters) {
    String result = "";
	int arrayIndex = 0;
	for(int i = 0; i < msg.length; i++){
		arrayIndex = msg[i];
		result = result + letters[arrayIndex];
	}
	return result;
}

//
//  takes an array of Strings, words
//  returns a String which consists of the first letter of every word in words that 
//  is longer than 3 letters, in order, and the return String is all caps
//
public String acronymize(String[] words) {
	String result = "";
	int wordLength = 0;
	for(int i = 0; i < words.length; i++){
		String s = "";
		s = s + words[i];
		wordLength = s.length();
		if(wordLength > 3){
			result = result + words[i].charAt(0);
		}
	}
	String upperResult = result.toUpperCase();
    return upperResult;
}

//
//  takes a String, and returns an array of ints that represent a count of the 
//  occurences of each letter in the text.  the count of all as (both upper and 
//  lowercase) will be stored in the 0th postion of the returned array.
//
public int[] letterCount(String text) {
	int[] count = new int[26];
	for(int i = 0; i < text.length(); i++){
		if(text.charAt(i) == 'A' || text.charAt(i) == 'a'){
			count[0]++;
		}
		else if(text.charAt(i) == 'B' || text.charAt(i) == 'b'){
			count[1]++;
		}
		else if(text.charAt(i) == 'C' || text.charAt(i) == 'c'){
			count[2]++;
		}
		else if(text.charAt(i) == 'D' || text.charAt(i) == 'd'){
			count[3]++;
		}
		else if(text.charAt(i) == 'E' || text.charAt(i) == 'e'){
			count[4]++;
		}
		else if(text.charAt(i) == 'F' || text.charAt(i) == 'f'){
			count[5]++;
		}
		else if(text.charAt(i) == 'G' || text.charAt(i) == 'g'){
			count[6]++;
		}
		else if(text.charAt(i) == 'H' || text.charAt(i) == 'h'){
			count[7]++;
		}
		else if(text.charAt(i) == 'I' || text.charAt(i) == 'i'){
			count[8]++;
		}
		else if(text.charAt(i) == 'J' || text.charAt(i) == 'j'){
			count[9]++;
		}
		else if(text.charAt(i) == 'K' || text.charAt(i) == 'k'){
			count[10]++;
		}
		else if(text.charAt(i) == 'L' || text.charAt(i) == 'l'){
			count[11]++;
		}
		else if(text.charAt(i) == 'M' || text.charAt(i) == 'm'){
			count[12]++;
		}
		else if(text.charAt(i) == 'N' || text.charAt(i) == 'n'){
			count[13]++;
		}
		else if(text.charAt(i) == 'O' || text.charAt(i) == 'o'){
			count[14]++;
		}
		else if(text.charAt(i) == 'P' || text.charAt(i) == 'p'){
			count[15]++;
		}
		else if(text.charAt(i) == 'Q' || text.charAt(i) == 'q'){
			count[16]++;
		}
		else if(text.charAt(i) == 'R' || text.charAt(i) == 'r'){
			count[17]++;
		}
		else if(text.charAt(i) == 'S' || text.charAt(i) == 's'){
			count[18]++;
		}
		else if(text.charAt(i) == 'T' || text.charAt(i) == 't'){
			count[19]++;
		}
		else if(text.charAt(i) == 'U' || text.charAt(i) == 'u'){
			count[20]++;
		}
		else if(text.charAt(i) == 'V' || text.charAt(i) == 'v'){
			count[21]++;
		}
		else if(text.charAt(i) == 'W' || text.charAt(i) == 'w'){
			count[22]++;
		}
		else if(text.charAt(i) == 'X' || text.charAt(i) == 'x'){
			count[23]++;
		}
		else if(text.charAt(i) == 'Y' || text.charAt(i) == 'y'){
			count[24]++;
		}
		else if(text.charAt(i) == 'Z' || text.charAt(i) == 'z'){
			count[25]++;
		}
	}
    return count;
}

//
//  takes an array of lettercounts like the one returned by the above method
//  returns the letter with the highest count.  This method always returns a lowercase char.
//  In case of tie, it returns first letter with that count (closest to 'a').
//
public char highestLetterCount(int[] letterCount) {
    char highest = 'a';
	int topCountSoFar = 0;
	int arrayIndex = 0;
	for(int i = 0; i < letterCount.length; i++){
		if(letterCount[i] == topCountSoFar){
			highest = highest;
		}
		else if(letterCount[i] > topCountSoFar){
			topCountSoFar = letterCount[i];
			arrayIndex = i;
			if(arrayIndex == 0){
				highest = 'a';
			}
			else if(arrayIndex == 1){
				highest = 'b';
			}
			else if(arrayIndex == 2){
				highest = 'c';
			}
			else if(arrayIndex == 3){
				highest = 'd';
			}
			else if(arrayIndex == 4){				
			highest = 'e';
						}
			else if(arrayIndex == 5){				
			highest = 'f';
						}
			else if(arrayIndex == 6){				
			highest = 'g';
						}
			else if(arrayIndex == 7){				
			highest = 'h';
						}
			else if(arrayIndex == 8){				
			highest = 'i';
						}
			else if(arrayIndex == 9){				
			highest = 'j';
						}
			else if(arrayIndex == 10){				
			highest = 'k';
						}
			else if(arrayIndex == 11){				
			highest = 'l';
						}
			else if(arrayIndex == 12){				
			highest = 'm';
						}
			else if(arrayIndex == 13){				
			highest = 'n';
						}
			else if(arrayIndex == 14){				
			highest = 'o';
						}
			else if(arrayIndex == 15){				
			highest = 'p';
						}
			else if(arrayIndex == 16){				
			highest = 'q';
						}
			else if(arrayIndex == 17){				
			highest = 'r';
						}
			else if(arrayIndex == 18){				
			highest = 's';
						}
			else if(arrayIndex == 19){				
			highest = 't';
						}
			else if(arrayIndex == 20){				
			highest = 'u';
						}
			else if(arrayIndex == 21){				
			highest = 'v';
						}
			else if(arrayIndex == 22){				
			highest = 'w';
						}
			else if(arrayIndex == 23){				
			highest = 'x';
						}
			else if(arrayIndex == 24){				
			highest = 'y';
						}
			else if(arrayIndex == 25){				
			highest = 'z';
			}
		}
	}
	return highest;
}

}
