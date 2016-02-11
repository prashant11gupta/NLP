import java.io.IOException;

public class Bigrams {
	
	public double calBigramProb(String sentence,ReadCorpus rc) throws IOException{
		
		Utility util = new Utility();
		
		String[] arrStr = sentence.trim().split("\\s+");
		double prob = 1.0;
		int len = arrStr.length;
		int i = 0;
		String prevWord =".";
		String word;
		String BigramWord;
		while(i < len){
			
			word = util.preProcess(arrStr[i]);
			
			BigramWord = prevWord +" "+word;
			
			prob = prob * getBigramProb(prevWord,BigramWord,rc);
			prevWord = util.preProcess(arrStr[i]);
			i++;
		}
		
		return prob;
		
	}
	
	public double getBigramProb(String prevWord,String BigramWord,ReadCorpus rc) throws IOException{
		
		double prevWordCount;
		double BigramWordCount;
		
		prevWordCount = rc.getCountToken(prevWord);
		BigramWordCount = rc.getBigramCount(BigramWord);
		if(prevWordCount != 0)
			return (BigramWordCount/prevWordCount);
		else
			return 0;
	}
	
		
	
}
