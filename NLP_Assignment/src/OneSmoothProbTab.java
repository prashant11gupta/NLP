import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;

public class OneSmoothProbTab {
	public static final NumberFormat formatter = new DecimalFormat("0.####E0");
	public void oneSmoothTab(ReadCorpus rc) throws IOException{
		OneSmoothing sm = new OneSmoothing();
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
				prob = sm.getOneSmoothProb(s, bigramWord,rc);
				System.out.format("%-20s",formatter.format(prob));
			}
			System.out.println();
		}
		
	}

}
