
public class Utility {
	public String preProcess(String word) {
        if((word = word.trim()).equals(".")){
            return word;
        }
        return word.replaceAll("\\W", "").toLowerCase();
    }
}
