package code;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearch{
		private String queryStr;
		private String content;
		public GoogleSearch(String queryStr){
			this.queryStr = queryStr;
		}
	
	private String fetchContent() throws IOException{

		URL url = new URL("https://www.google.com/search?q="+queryStr+"+download"+"&num=50&oe=utf8");
		URLConnection conn = url.openConnection(); 
		conn.setRequestProperty("user-agent", "Chrome/47.0.2526.106");
		InputStream in =  conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
		String retVal = "";
		
		String line = null;
		while((line = br.readLine())!= null){ 
			retVal += (line + "\n"); 
		}
		return retVal;
	}
	public HashMap<String, String> getResults() throws IOException{
		HashMap<String, String> retVal = new HashMap<>();
		if (content == null){
			content = fetchContent();
		}
		
		Document doc = Jsoup.parse(content);	
		Elements divGs = doc.select("div.g");
		
		for(Element divG : divGs){			
			try{
				Element h3R = divG.select("h3.r").get(0);
				Element aTag = h3R.select("a").get(0);
				String title = aTag.text();
				String tmp = aTag.attr("href");
				String url = tmp.substring(7, tmp.indexOf("&sa"));
		
				retVal.put(title, url);
			} 
			catch (IndexOutOfBoundsException ex){
				continue;
			}		
		}
		return retVal;		
	}
}