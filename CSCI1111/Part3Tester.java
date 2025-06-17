import java.util.*;

public class Part3Tester{

	public static void main(String[] args){


		// TEST 1 ***************************************************************************************************************
		//This test case will esure that method .splitSentence is working correctly and that it breaks up all the words in a given sentence and seperates it by creating every word as it's own string. 
		// **********************************************************************************************************************
		SentencePart3 expected1 = new SentencePart3("call leader help protect refuge covid19 provid qualiti health care", "RJIshak", "April 19 2020");
		String[] words = expected1.splitSentence();
		String[] expected = {"call", "leader", "help", "protect", "refuge", "covid19", "provid", "qualiti", "health", "care"};

		if(Arrays.equals(words, expected)){
			System.out.println("YOU PASSED TEST1!!!!");
		}
	   	else 
	   		System.out.println("your word splitting wasn't correct");

		// TEST 2 ***************************************************************************************************************
		// This test case makes sure that method .getTopWords is working correctly and that it accounts for the frequency for which a given word is present in the list of words in sentences. 
		// **********************************************************************************************************************
		ArrayList sentences = new ArrayList();
		sentences.add(expected1);
		sentences.add(expected1);
		sentences.add(new SentencePart3("call help protect", "RJIshak", "April 19 2020"));
		sentences.add(new SentencePart3("these are random words words", "RJIshak", "April 19 2020"));
 		HashMap map = DriverPart3.getTopWords(sentences);

	    ArrayList results = new ArrayList();
	    for(int i = 0; i < map.keySet().toArray().length; i++){
	      int count = (Integer) map.get(map.keySet().toArray()[i]);
	      String num = "" + count;
	      while(num.length() < 5)
	        num = "0" + num;
	      results.add(num + " of "+ map.keySet().toArray()[i]);
	    }

	    ArrayList desired = new ArrayList();
	    desired.add("00003 of protect");
		desired.add("00003 of help");
		desired.add("00003 of call");
		desired.add("00002 of words");
		desired.add("00002 of refuge");
		desired.add("00002 of qualiti");
		desired.add("00002 of provid");
		desired.add("00002 of leader");
		desired.add("00002 of health");
		desired.add("00002 of covid19");
		desired.add("00002 of care");
		desired.add("00001 of these");
		desired.add("00001 of random");
		desired.add("00001 of are");

	    Collections.sort(results);
	    Collections.reverse(results);
	    if(results.equals(desired)){
	    	System.out.println("YOU PASSED TEST2!!!!");
	    }
	   	else 
	   		System.out.println("your HashMap wasn't correct");

		// TEST 3 ***************************************************************************************************************
		//This testcase is ensuring that .splitSentenceBigram is working correctly by using the disconary class to determine and seperate bigrams in a given sentece 
		// **********************************************************************************************************************
		SentencePart3 sent1 = new SentencePart3("We would like to combine health care as opposed to taking care of someones health", "RJIshak", "April 19 2020");
		SentencePart3 sent2 = new SentencePart3("We would like to combine healthcare as opposed to taking care of someones health care", "RJIshak", "April 19 2020");
		SentencePart3 sent3 = new SentencePart3("We would like to combine healthcare as opposed to taking care of someones care", "RJIshak", "April 19 2020");
		String[] e1 = 		 {"We", "would", "like", "to", "combine", "healthcare", "as", "opposed", "to", "taking", "care", "of", "someones", "health"};
		String[] expected2 = {"We", "would", "like", "to", "combine", "healthcare", "as", "opposed", "to", "taking", "care", "of", "someones", "healthcare"};
		String[] expected3 = {"We", "would", "like", "to", "combine", "healthcare", "as", "opposed", "to", "taking", "care", "of", "someones", "care"};

		String[] result1 = sent1.splitSentenceBigram();
		String[] result2 = sent2.splitSentenceBigram();
		String[] result3 = sent3.splitSentenceBigram();

		// uncomment these to help you debug!
		//System.out.println(Arrays.toString(result1));
		//System.out.println(Arrays.toString(result2));
		//System.out.println(Arrays.toString(result3));

		if (Arrays.equals(e1, result1)){
			System.out.println("YOU PASSED TEST3a!!!!");
		}
	   	else if (result1 != null)
	   		System.out.println("your bigrams weren't correct 1");
		if (Arrays.equals(expected2, result2))
			System.out.println("YOU PASSED TEST3b!!!!");
	   	else if (result1 != null)
	   		System.out.println("your bigrams weren't correct 2");		
		if (Arrays.equals(expected3, result3))
			System.out.println("YOU PASSED TEST3c!!!!");
	   	else if (result1 != null)
	   		System.out.println("your bigrams weren't correct 3");

	}
}