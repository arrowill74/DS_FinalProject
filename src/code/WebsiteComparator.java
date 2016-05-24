package code;

import java.util.Comparator;


public class WebsiteComparator implements Comparator<Webpage>{
	
	   @Override
	   public int compare(Webpage o1, Webpage o2){
		   
		   return o2.score - o1.score;
	   }
}
