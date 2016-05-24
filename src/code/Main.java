package code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		ArrayList<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("MEGA", 10));
		keywords.add(new Keyword("mega", 10));
		keywords.add(new Keyword("Mega", 10));
		keywords.add(new Keyword("MG", 10));
		keywords.add(new Keyword("¦r¹õ", 10));
		keywords.add(new Keyword("ZIPPYSHARE",7));
		keywords.add(new Keyword("Zippyshare", 7));
		keywords.add(new Keyword("ZS", 7));
		keywords.add(new Keyword("BT", 7));
		keywords.add(new Keyword("anime", 1));
		keywords.add(new Keyword("Anime", 1));
		keywords.add(new Keyword("download", 10));
		keywords.add(new Keyword("Download", 10));
		keywords.add(new Keyword("episode", 5));
		keywords.add(new Keyword("Episode", 5));
		keywords.add(new Keyword("720", 10));
		keywords.add(new Keyword("1080", 7));
		keywords.add(new Keyword("subtitle", 10));
		keywords.add(new Keyword("Subtitle", 10));
		keywords.add(new Keyword("KTXP", 10));
		keywords.add(new Keyword("Ktxp", 10));
		keywords.add(new Keyword("Dymy", 10));
		keywords.add(new Keyword("Arita", 7));
		keywords.add(new Keyword("Thanks for moderator", 1));
		keywords.add(new Keyword("Selfless sharing", 1));
		keywords.add(new Keyword("wiki", -10000));
		keywords.add(new Keyword("bahamut", -10000));
		keywords.add(new Keyword("Amazon", -10000));
		keywords.add(new Keyword("Mp3", -10000));
		keywords.add(new Keyword("mp3", -10000));
		keywords.add(new Keyword("MP3", -10000));
		keywords.add(new Keyword("mP3", -10000));
		keywords.add(new Keyword("pinterest", -10000));
		keywords.add(new Keyword("subtitleseeker", -10000));
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			
			String queryStr = sc.nextLine();
			Redefine redefine = new Redefine(keywords);
			ArrayList<Webpage> result = redefine.query(queryStr);
			
			StringBuilder sb = new StringBuilder();
			while(!result.isEmpty()){
				Webpage removed = result.remove(0);
				if(sb.length() > 1){
					sb.append("\n");
				}
				sb.append(removed.toString());
			}
			System.out.println(sb.toString());
			}
		sc.close();
		}
	}

