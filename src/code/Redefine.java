package code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class Redefine {	
	public ArrayList<Webpage> org;
	private ArrayList<Keyword> keywords;
	
	public Redefine(ArrayList<Keyword> keywords){
		this.keywords = keywords;
	}
	
	public ArrayList<Webpage> query(String searchWord) throws IOException{
		 
		GoogleSearch gSearch = new GoogleSearch(searchWord);
		Map<String, String> UrlMap = gSearch.getResults();
		
		org = new ArrayList<>();
		for(Entry<String, String> entry : UrlMap.entrySet()){
		    String title = entry.getKey();
		    String urlStr = entry.getValue();
		    Webpage root = new Webpage(title, urlStr);
		    org.add(root);
		    root.calcScore(keywords);
		    
		}
		Collections.sort(org , new WebsiteComparator());
		return org;
	 }
	
}
