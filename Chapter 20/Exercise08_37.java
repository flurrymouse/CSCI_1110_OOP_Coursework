import java.util.*;

public class Exercise08_37 {
  public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    String[][] stateCapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };
    ArrayList<String[]> pl = new ArrayList<>(Arrays.asList(stateCapital));
    int correctCount = 0;
    while(!pl.isEmpty()) {
    	int randomA = (int)(Math.random() * pl.size());
    	String[] Fpairs = pl.get(randomA);
	    pl.remove(Fpairs);
    	System.out.print("What is the capital of " + Fpairs[0] + "? ");
    	   String capital = input.nextLine().trim().toLowerCase();
    	   if (capital.toLowerCase().equals(Fpairs[1].toLowerCase())) {
    	        System.out.println("Your answer is correct");
    	        correctCount++;
    	pl.remove(Fpairs);
    } else
        System.out.println("The correct answer should be " + Fpairs[1]);
     
    }

    System.out.println("The correct count is " + correctCount);
  }
}
