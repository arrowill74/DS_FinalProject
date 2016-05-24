package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class KeywordCounter {
	public String urlstr;
	public String content;
	
	public KeywordCounter(String urlstr) {
		this.urlstr = urlstr;
	}
	
	private String fetchContent() throws IOException{
		URL url = new URL(this.urlstr);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("user-agent", "Chrome/47.0.2526.106");
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String retVal = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			retVal = retVal + line + "\n";
		}
		return retVal;
	}
	public int countKeyword(String keyword) throws IOException{
		if(content == null){
			content = fetchContent();
		}
		int retVal = 0;
		int fromIdx = 0;
		int found = 0;
		while((found = content.indexOf(keyword, fromIdx)) != -1){
			retVal++;
			fromIdx = found + keyword.length();
		}
		return retVal;
	}
}
