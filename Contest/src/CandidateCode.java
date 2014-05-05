import java.io.*;
public class CandidateCode 
{ 
    public static int fashion(int[] scores)
    {
    	int len = scores.length;
    	int score = scores[len/2];
    	int i=len/2+1;
    	int j=len/2-1;
    	while(i<len && j>=0){
    		if(scores[i]==scores[j]){
    			score=score+scores[i];
    		}
    		i++;
    		j--;
    	}
    	
    	return score;
    }
    
    public static void main(String[] args) {
		System.out.println(new CandidateCode().fashion(new int[]{5,6,7,3,5}));
	}
}