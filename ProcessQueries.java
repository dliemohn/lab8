import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessQueries {
    public static void main (String[] args) throws IOException {
        if (args == null)
            System.out.println("Enter a URL");
        ArrayList<WebPageIndex> wpis = new ArrayList<WebPageIndex>();
        File f = new File(args[0]);
        Scanner urlReader = new Scanner(f);
        while(urlReader.hasNextLine()) {
            wpis.add(new WebPageIndex(urlReader.nextLine()));
        }
        ArrayList<String> queries = new ArrayList<String>();
        for( int i = 1; i < args.length; i++) {
            queries.add(args[i]);
        }
        URLComparator engine = new URLComparator(queries);
        MyPriorityQueue<WebPageIndex> results = new MyPriorityQueue<WebPageIndex>(engine);
        for(WebPageIndex w: wpis) {
            results.add(w);
        }
        ArrayList<WebPageIndex> holder = new ArrayList<WebPageIndex>();
        while(!results.isEmpty()) {
            WebPageIndex top = results.remove();
            holder.add(top);
            System.out.println(engine.score(top) + "\t" + top.getUrl());
        }
       
        for(WebPageIndex w: holder)
            results.add(w);
       
        Scanner reader = new Scanner(System.in);
        String nex = reader.nextLine();
        while(!nex.equals(""))
        {
            wpis.add(new WebPageIndex(nex));
            results.add(wpis.get(wpis.size()-1));
            nex = reader.nextLine();
        }
       
    }
}