/**
 * This class contains the code to compute the relevance score of a
 * web page, in response to a query.  It also contains a method to
 * compare the scores of two web pages.
 *
 * @author John Donaldson (Spring 2016)
 */

import java.util.*;

class URLComparator implements Comparator<WebPageIndex> {

   List<String> query;
  
   URLComparator(List<String> query){
      this.query = query;
   }
  
   public int score(WebPageIndex idx){
      int score = 0;
      for (int i = 0; i < query.size(); i++) {
          String cur = query.get(i);
          score += idx.getCount(cur);
      }
      return score;
   }
     
    public int compare(WebPageIndex idx1, WebPageIndex idx2){
       int s1 = score(idx1);
       int s2 = score(idx2);
       return s1-s2;
    }

}