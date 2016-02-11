import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;

public class BigramProbTable {
	public static final NumberFormat formatter = new DecimalFormat("0.####E0");
	public void BiGramProbTab(ReadCorpus rc) throws IOException{
		Bigrams bg = new Bigrams();
		String bigramWord;
		double prob;
		
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
				prob = bg.getBigramProb(s, bigramWord,rc);
				System.out.format("%-20s",formatter.format(prob));
			}
			System.out.println();
		}
		
	}
	
}
