import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CandidateCode
    {
        public static void main(String[] args)
        {
            int[] number = { 3, 4, 2, 5, 1 };

           int result = get_order(number);
           System.out.println(result);
        }

        public static int get_order(int[] unsortedArray)
        {

        	
            int temp;
            int swap = 0;

            Integer[] sortedArray = new Integer[unsortedArray.length];
            int k=0;
            for (Integer integer : unsortedArray) {
				sortedArray[k++] = integer;
			}
            
            Arrays.sort(sortedArray, Collections.reverseOrder());
            int arrayLength = sortedArray.length;
            for (int i = 0; i < arrayLength; i++)
            {
                if (sortedArray[i] != unsortedArray[i])
                {
                    temp = unsortedArray[i];
                    unsortedArray[i] = sortedArray[i];
                    for (int j = i + 1; j < arrayLength; j++)
                    {
                        if (unsortedArray[j] == sortedArray[i])
                        {
                            unsortedArray[j] = temp;
                            swap++;
                            break;
                        }
                    }
                }

            }
            return swap;
        }
    }
