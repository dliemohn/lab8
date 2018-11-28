import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessQueries {
	public static void main(String[] args) throws IOException {
		try {
			File f = new File(args[0]);
		} catch (Exception e) {
			System.out.println("Enter a file with a list of URLs to search from.");
			System.exit(-1);
		}
		ArrayList<WebPageIndex> wpis = new ArrayList<WebPageIndex>();
		File f = new File(args[0]);
		Scanner urlReader = new Scanner(f);
		while (urlReader.hasNextLine()) {
			wpis.add(new WebPageIndex(urlReader.nextLine()));
		}
		ArrayList<String> queries = new ArrayList<String>();
		System.out.println("Enter a Query");
		Scanner input = new Scanner(System.in);
		String query = input.nextLine();
		Scanner queryReader = new Scanner(query);
		while(queryReader.hasNext()) {
			queries.add(queryReader.next());
		}
		System.out.println(query);
		URLComparator engine = new URLComparator(queries);
		MyPriorityQueue<WebPageIndex> results = new MyPriorityQueue<WebPageIndex>(engine);
		for (WebPageIndex w : wpis) {
			results.add(w);
		}
		ArrayList<WebPageIndex> holder = new ArrayList<WebPageIndex>();
		while (!results.isEmpty()) {
			WebPageIndex top = results.remove();
			holder.add(top);
			System.out.println(engine.score(top) + "\t" + top.getUrl());
		}

		for (WebPageIndex q : holder)
			results.add(q);

	}
}
