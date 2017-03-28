/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingexample;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jeppjleemoritzled
 */
public class SortingExample
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int[] numbers = new int[11];
        Random r = new Random(1337);
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = r.nextInt(20);
        }

        int[] sortedNumbers = insertionSort(numbers);

        printArray(numbers);
        System.out.println("Sorted: ");
        printArray(sortedNumbers);
    }

    public static void printArray(int[] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            System.out.print(input[i] + " ");
        }
    }

    public static int[] bubbleSort(int[] input)
    {
        // Needs implementation
        int[] newArray = input.clone();

        int j;
        boolean flag = true;
        int temp;

        while (flag)
        {
            flag = false;
            for (j = 0; j < newArray.length - 1; j++)
            {
                if (newArray[j] > newArray[j + 1])
                {
                    temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                    flag = true;
                }
            }
        }
        
        input = newArray;
         
        return input;
    }

    public static int[] selectionSort(int[] input)
    {
        // Needs implementation
        int[] newArray = input.clone();
        
        for (int i = 0; i < newArray.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < newArray.length; j++)
                if (newArray[j] < newArray[index])
                    index = j;
      
            int smallerNumber = newArray[index]; 
            newArray[index] = newArray[i];
            newArray[i] = smallerNumber;
        }
        
        input = newArray;

        return input;
    }

    public static int[] insertionSort(int[] input)
    {
        // Needs implementation
        int[] newArray = input.clone();
        
                int temp;
        for (int i = 1; i < newArray.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(newArray[j] < newArray[j-1]){
                    temp = newArray[j];
                    newArray[j] = newArray[j-1];
                    newArray[j-1] = temp;
                }
            }
        }
        
        input = newArray;

        return input;
    }

}
