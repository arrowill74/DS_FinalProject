package code;

import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> keywords = new ArrayList<>();
	
	public void add(Keyword K){
		keywords.add(K);
		System.out.println("Done");
	}
	
	public void output(){
		StringBuilder sb = new StringBuilder();
		for(Keyword k : keywords){
			sb.append(k.toString()+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public void sort(){
		this.keywords = doQuickSort(this.keywords);
		System.out.println("Done");
	}
	
	private ArrayList<Keyword> doQuickSort(ArrayList<Keyword> keywords) {
		if(keywords.size() <= 1){
			return keywords;
		}
		
		ArrayList<Keyword> lt = new ArrayList<>();
		ArrayList<Keyword> eq = new ArrayList<>();
		ArrayList<Keyword> gt = new ArrayList<>();
		ArrayList<Keyword> retVal = new ArrayList<>();
		int IndexOfList = keywords.size() / 2;
		Keyword point = keywords.get(IndexOfList);
		
		for(Keyword keyword : keywords){
			if(keyword.count < point.count){
				lt.add(keyword);
			}
			else if (keyword.count > point.count){
				gt.add(keyword);
			}
			else {
				eq.add(keyword);
			}
		}
		
		retVal.addAll(doQuickSort(lt));
		retVal.addAll(eq);
		retVal.addAll(doQuickSort(gt));
		
		return retVal;
	}
	
	private int getLCSLength(String str1,String str2){
		int[][] table = new int[str2.length()+1][str1.length()+1];
		
		for(int i =0; i<str2.length()+1; i++){
			table[i][0]=0;
		}
		
		for(int i =0; i<str1.length()+1; i++){
			table[0][i]=0;
		}
		
		for(int i =1; i<str2.length()+1; i++){
			for(int j=1; j<str1.length()+1;j++){
				char char1 = str1.charAt(j-1);
				char char2 = str2.charAt(i-1);
				
				if(char2 == char1){
					table[i][j] = table[i-1][j-1]+1;
				}
				else{
					table[i][j] = table[i-1][j] > table[i][j-1] ? table[i-1][j] : table[i][j-1];
				}
			}
		}
		return table[str2.length()][str1.length()];
	}
	
	public void find(String pattern){
		int maxLength = Integer.MIN_VALUE;
		Keyword lcsKeyword = null;
		
		for(Keyword k : keywords){
			int lcsLength = getLCSLength(k.name, pattern);
			if(lcsLength > maxLength){
				maxLength = lcsLength;
				lcsKeyword = k;
			}
		}
		System.out.println(lcsKeyword);
	}
}
