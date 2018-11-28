import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessQueries {
	public static void main(String[] args) throws IOException {

		// catch errors in user input
		try {
			File f = new File(args[0]);
		} catch (Exception e) {
			System.out.println("Enter a file with a list of URLs to search from.");
			System.exit(-1);
		}

		// For large files/urls the program take a few seconds to prepare database
		System.out.println("Please wait...");
		ArrayList<WebPageIndex> wpis = new ArrayList<WebPageIndex>();
		File f = new File(args[0]);
		Scanner urlReader = new Scanner(f);

		// Creates a WPI for every URL, this takes a while on large files
		while (urlReader.hasNextLine()) {
			wpis.add(new WebPageIndex(urlReader.nextLine()));
		}
		// While loop that takes queries until user exit
		while (true) {
			//Creates list of queries,and fills with User input strings
			ArrayList<String> queries = new ArrayList<String>();
			System.out.println("Enter a Query");
			Scanner input = new Scanner(System.in);
			String query = input.nextLine();
			Scanner queryReader = new Scanner(query);
			while (queryReader.hasNext()) {
				queries.add(queryReader.next());
			}
			//Make URL Comparator with the list of queries 
			URLComparator engine = new URLComparator(queries);
			//Create a MyPriorityQueue for the WebPageIndex list using the URL Comparator
			MyPriorityQueue<WebPageIndex> results = new MyPriorityQueue<WebPageIndex>(engine);
			for (WebPageIndex w : wpis) {
				results.add(w);
			}
			//Print results and hold the WPIs in a holder index
			ArrayList<WebPageIndex> holder = new ArrayList<WebPageIndex>();
			while (!results.isEmpty()) {
				WebPageIndex top = results.remove();
				holder.add(top);
				System.out.println("Score: [" + engine.score(top) + "]\t" + top.getUrl());
			}
			//then refill the MyPriorityQueue
			for (WebPageIndex q : holder)
				results.add(q);
			
			//Prompts user to enter another query
			System.out.println("Would you like to enter another query?  Enter n if no. Enter any other key to continue.");
			if (input.next().equals("n"))
				System.exit(0);
			else {
				query = input.nextLine();
			}
		}
	}
}
