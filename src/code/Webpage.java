package code;

import java.io.IOException;
import java.util.ArrayList;

public class Webpage {
	public String name;
	public String url;
	public KeywordCounter counter;
	public int score;
	
	public Webpage(String name, String url) {
		this.name = name;
		this.url = url;
		this.counter=new KeywordCounter(url);
	}
	
	public void calcScore(ArrayList<Keyword> keywords) throws IOException {
		score = 0;
		for(Keyword k : keywords){
			try{
			score += ((k.weight) * (counter.countKeyword(k.name)));
		
			}
			catch(IOException ex){
				return;
			}
		}
	}
	@Override
	public String toString(){
    	return "["+name+","+url+","+score+"]";
    }
}
