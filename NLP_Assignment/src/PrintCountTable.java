import java.io.IOException;
import java.util.LinkedHashSet;

public class PrintCountTable {	
	public void PrintCntTbl(ReadCorpus rc) throws IOException{
		
		String bigramWord;
		int count;
		
		LinkedHashSet<String> set;
		set  = rc.getHashSet();
				
		
		System.out.format("%-20s","");
		for(String s:set){
			System.out.format("%-20s",s);
		}
		System.out.println("\n");
		
		for(String s: set){
			System.out.format("%-20s",s);
			for(String s1: set){
				bigramWord = s+" "+s1;
				count = rc.getBigramCount(bigramWord);
				System.out.format("%-20s",(count));
			}
			System.out.println();
		}
		
	}
}