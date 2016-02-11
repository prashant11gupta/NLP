import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;


public class ReadCorpus {
	private  Map<String,Integer> tokenCount;
	private  Map<String,Integer> bigramCount;
	private  LinkedHashSet<String> wordSet;
	private  int N = 0;
	
	public ReadCorpus(String fileName,String sentence) throws IOException{
		tokenCount = new HashMap<String,Integer>();
		bigramCount = new HashMap<String,Integer>();
		wordSet = new LinkedHashSet<String>();
		wordCount(fileName);
		totalBigrams();
		sentenceWords(sentence);
	}
	
	private void sentenceWords(String sentence) {
		Utility uti = new Utility();
		
		for(String word : sentence.split("\\s+")){
			word = uti.preProcess(word);
			if(!(wordSet.contains(word))){
				wordSet.add(word);
			}
		}
	}

	public LinkedHashSet<String> getHashSet(){
		return wordSet;
	}


	private void wordCount(String fileName) throws IOException{	
		
		Utility util = new Utility();
		File file = new File(fileName);
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line = "";
			int count;
			String prevWord = ".";
			String bigramsWord = null;
			while((line = br.readLine()) != null){
				String[] corpusWord = line.trim().split("\\s+");
				for (String word : corpusWord){
					word = util.preProcess(word);
					
					if(tokenCount.containsKey(word)){
						count = tokenCount.get(word);
						count++;
						tokenCount.put(word,count);
					}else{
						tokenCount.put(word,1);
					}
					
					
					bigramsWord = prevWord + " " + word;
					if(bigramCount.containsKey(bigramsWord)){
						count = bigramCount.get(bigramsWord);
						count++;
						bigramCount.put(bigramsWord, count);
					}else{
						bigramCount.put(bigramsWord, 1);
					}
					
					prevWord = word;
				}
				
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found" + file.toString());
		}catch(Exception e){
			System.out.println("Could not read file" + file.toString());
		}
		
		
		
	}
	
	private void totalBigrams(){
		
		Collection<Integer> c =bigramCount.values();
		Iterator<Integer> itr = c.iterator();
		while(itr.hasNext()){
			N = N + itr.next();
	}
		
		
	}
	public int getCountToken(String word){
		if(tokenCount.containsKey(word))
			return tokenCount.get(word);
		else
			return 0;
	}
	
	public int getBigramCount(String BigramWord){
		if(bigramCount.containsKey(BigramWord))
			return bigramCount.get(BigramWord);
		else
			return 0;
	}
	
	
	public int getCountBiWords(int freq){
		int count = 0;
		Collection<Integer> c  = bigramCount.values();
		Iterator<Integer> itr = c.iterator();
		while(itr.hasNext()){
			if (itr.next() == freq)
				count++;
		}
		return count;
	}
	
	public int getTotalBiCount(){
		return N;
	}
	
	public double getBigramVocabSize() {
		
		return bigramCount.size();
	}
	
	public double getTokenVocabSize() {
		
		return tokenCount.size();
	}
	
}
