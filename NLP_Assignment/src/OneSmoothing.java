import java.io.IOException;

public class OneSmoothing {
	
	public double calOneSmoothProb(String sentence,ReadCorpus rc) throws IOException{
		
		Utility util = new Utility();
		
		String[] arrStr = sentence.trim().split("\\s+");
		double prob = 1.0;
		int len = arrStr.length;
		int i = 0;
		String prevWord= ".";
		String word;
		String bigramWord;
		while(i < len){
			
			word = util.preProcess(arrStr[i]);
			
			bigramWord = prevWord +" "+word;
			
			prob = prob * getOneSmoothProb(prevWord,bigramWord,rc);
			prevWord = util.preProcess(arrStr[i]);
			i++;
		}
		
		return prob;
		
	}

	public double getOneSmoothProb(String prevWord, String bigramWord,ReadCorpus rc) throws IOException {
	
		double prevWordCount;
		double bigramWordCount;
		double unigramSize;
		prevWordCount = rc.getCountToken(prevWord);
		bigramWordCount = rc.getBigramCount(bigramWord);
		unigramSize = rc.getTokenVocabSize();
		
	
		return ((bigramWordCount+1)/(prevWordCount+unigramSize));
		
	}
	
}

