import java.io.IOException;

public class GoodTuring {

	public double calGoodTurProb(String sentence,ReadCorpus rc) throws IOException{
		
		
		Utility util = new Utility();
		double prob = 1.0;
		int i = 1;
		String prevWord= null;
		String bigramWord = null;
		String currWord = null;
		
		String[] arrStr = sentence.trim().split("\\s+");
		while(i < arrStr.length){
			
			prevWord = util.preProcess(arrStr[i-1]);
			currWord = util.preProcess(arrStr[i]);
			
			bigramWord = prevWord + " " + currWord;
			prob = prob * getProb(bigramWord,rc);
			
			
			i++;
		}
		
		return (prob);
	}


	public double getProb(String bigramWord,ReadCorpus rc) throws IOException {
		
		int count = rc.getBigramCount(bigramWord);
		
		if (count == 0){
			return getNotSeenProb(bigramWord,rc);
			 
		}else{
			return getWordProb(bigramWord,rc);
		}
		
	}


	private double getWordProb(String word,ReadCorpus rc) throws IOException {
		
		
		int BiCount = rc.getBigramCount(word);
		double BiCountFreq = rc.getCountBiWords(BiCount);
		double BiCountFreq1 = rc.getCountBiWords(BiCount + 1);
		double totalBiCount = rc.getTotalBiCount();
		
		double val = (((BiCount + 1)*(BiCountFreq1))/BiCountFreq);
		
		if (val == 0)
			val = getNotSeenProb(word,rc);
		
		return (val/totalBiCount);
	}


	public static double getNotSeenProb(String word,ReadCorpus rc) throws IOException{
		
		
		double BiCountFreq = rc.getCountBiWords(1);
		double totalBiCount = rc.getTotalBiCount();
		
	
		return (BiCountFreq/totalBiCount);
				
	}
}	