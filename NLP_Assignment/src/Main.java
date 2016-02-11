import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		String[] sentences = {"The president has relinquished his control of the company's board",
							  "The chief executive officer said the last year revenue was good"};
		
		String fileName = "corpus.txt";
		
		for (String sentence:sentences){
			
			System.out.println("Result for sentence :\""+sentence+"\"\n");
			ReadCorpus rc = new ReadCorpus(fileName,sentence);				// reads corpus and stores tokens and bigrams in hashmap.
		
			Bigrams bgrams  = new Bigrams();
			System.out.println("Bigram probability: "+bgrams.calBigramProb(sentence,rc)+"\n"); // calculates bigram probability
		
		
			OneSmoothing smooth = new OneSmoothing();
			System.out.println("One Smoothing Probability: "+smooth.calOneSmoothProb(sentence,rc)+"\n"); // calculates One smoothing probability
		
		
			GoodTuring gt = new GoodTuring();
			System.out.println("Good Turing Probability: "+gt.calGoodTurProb(sentence,rc)+"\n"); // calculate Good turing probability
		
		
			PrintCountTable pt = new PrintCountTable(); 
			
			System.out.println("Bigram Count Table :\n");
			pt.PrintCntTbl(rc);				//Print Bigram Counts table
			System.out.println("\n\n");
		
			System.out.println("Bigram Probability Table :\n");
			BigramProbTable bt = new BigramProbTable();
			bt.BiGramProbTab(rc);			//Print Bigram probability table
			System.out.println("\n\n");
			
			System.out.println("One Smoothing Probability Table :\n ");
			OneSmoothProbTab sm = new OneSmoothProbTab();
			sm.oneSmoothTab(rc);			//Print Bigram One smoothing  table
			System.out.println("\n\n");
			
			System.out.println("Good Turing Probability Table :\n");
			GoodTurProbTab gt1 = new GoodTurProbTab();
			gt1.TurProbTab(rc);				//Print Good Turing table
			System.out.println("\n\n");
		
		}
	}
}
