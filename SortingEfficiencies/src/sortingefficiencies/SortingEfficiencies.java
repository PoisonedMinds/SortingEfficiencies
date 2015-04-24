package sortingefficiencies;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * @title SortingEfficiencies
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 16-Apr-2015 10:32:46 AM
 * @purpose The purpose of this program is to
 */
public class SortingEfficiencies {

    public static long shift = 0, loop = 0, comp = 0;

    public static void main(String[] args) {
        int amount;
        long time;
        List<Integer> numbers=new ArrayList();
        amount = Integer.parseInt(JOptionPane.showInputDialog("How many random numbers do you want to generate."));
        int nums[] = new int[amount];
        System.out.print("The unsorted list is: ");//output the unsorted list
        for (int i = 0; i < amount; i++) {
            nums[i] = (int) (Math.random() * 1001);//generate random numbers
            System.out.print(nums[i] + ", ");
        }
        for (int i =0;i<nums.length;i++){
        numbers.add(nums[i]);
    }
 

        //execute different sorting algorithims 
        time = System.currentTimeMillis();
        selectionSort(nums);
        time = System.currentTimeMillis() - time;
        System.out.print("\n\nThe list sorted with selection sort is: ");//output the sorted list
        for (int i = 0; i < amount; i++) {
            System.out.print(nums[i] + ", ");
        }
                System.out.println("\nIt took " + time + " miliseconds\n"+comp+" comparisons\n"+shift+" varible switches (when 1 varible is set equal to something else)\nand "+loop+" iterations.");
for (int i =0;i<nums.length;i++){
        nums[i]=numbers.get(i);
    }
         
        
        comp=0;  
        shift=0; 
        loop=0;
        time = System.currentTimeMillis();

        bubbleSort(nums);
        time = System.currentTimeMillis() - time;
        System.out.print("\nThe list sorted with bubble sort is: ");//output the sorted list
        for (int i = 0; i < amount; i++) {
            System.out.print(nums[i] + ", ");
        }
                System.out.println("\nIt took " + time + " miliseconds\n"+comp+" comparisons\n"+shift+" varible switches (when 1 varible is set equal to something else)\nand "+loop+" iterations.");
for (int i =0;i<nums.length;i++){
        nums[i]=numbers.get(i);
    }
        
        comp=0;
        shift=0; 
        loop=0;
        time = System.currentTimeMillis();

        insertionSort(nums);
        time = System.currentTimeMillis() - time;
        System.out.print("\nThe list sorted with insertion sort is: ");//output the sorted list
        for (int i = 0; i < amount; i++) {
            System.out.print(nums[i] + ", ");
        }
                System.out.println("\nIt took " + time + " miliseconds\n"+comp+" comparisons\n"+shift+" varible switches (when 1 varible is set equal to something else)\nand "+loop+" iterations.");
for (int i =0;i<nums.length;i++){
        nums[i]=numbers.get(i);
    }
        
        comp=0; 
        shift=0; 
        loop=0;

        time = System.currentTimeMillis();

        quickSort(nums, 0, nums.length - 1);
        time = System.currentTimeMillis() - time;
        System.out.print("\nThe list sorted with quick sort is: ");//output the sorted list
        for (int i = 0; i < amount; i++) {
            System.out.print(nums[i] + ", ");
        }
                System.out.println("\nIt took " + time + " miliseconds\n"+comp+" comparisons\n"+shift+" varible switches (when 1 varible is set equal to something else)\nand "+loop+" iterations.");
    }
//method that switches the place of 2 numbers in an int array

    public static void switchPlace(int nums[], int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
        shift=shift+3;

    }
//method that calls switchPlaces if a smaller number is found before a larger one

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            comp++;
            loop++;//cycle through all numbers
            for (int j = i + 1; j < nums.length; j++) {
                comp++;
                loop++;//cycle through all numbers to compare to
                comp++;
                if (nums[i] > nums[j]) {//compare the numbers

                    switchPlace(nums, i, j);
                }
            }
        }
    }
//method that call switchPlace if a smaller number is found after a larger one.

    private static void bubbleSort(int[] nums) {
        boolean check;//check to track when the algorithim is done
        for (int j = 1; j < nums.length; j++) {
            comp++;
            loop++;
            check = false;
            for (int i = 0; i < nums.length - 1; i++) {
                comp++;
                loop++;//cycle through all numbers
                comp++;
                if (nums[i] > nums[i + 1]) {//compare numbers
                    switchPlace(nums, i, i + 1);//call switchPlace
                    check = true;//trip the boolean check
                }
            }
            comp++;
            if (check == false) {
                
                break;
            }
        }

    }
//method that iterates through the array, sorting it relative to the srounding number each time until the array is completely sorted

    private static void insertionSort(int[] nums) {
        int num, index;
        for (int i = 1; i < nums.length; i++) {//cycle through the second index to the last index
            comp++;
            loop++;
            index = i;
            shift++;
            num = nums[i];//stored number
            shift++;
            
            while (index > 0 && nums[index - 1] > num) {//if the index is before
//0 and the number that comes before tat index is great then the current one, move that number to the left 
                comp++;
                loop++;
                nums[index] = nums[index - 1];
                shift++;
                index--;
            }
            nums[index] = num;
             shift++;//place the stored number in the correct spot
        }

    }

    public static void quickSort(int nums[], int start, int end) {
        loop++;
        comp++;
        if (start < end) {//continue if the section is greater than 1
            
            int numb = split(nums, start, end);
            shift++;//find the place of a number
            quickSort(nums, start, numb - 1);//redo this with the number whoes spot was found
            quickSort(nums, numb + 1, end);

        }

    }

    public static int split(int nums[], int start, int end) {
        boolean left = true;//bolean to track which side to move
        int number = nums[start];//store number
        while (start < end) {//while the size is greater than 1
            comp++;
            comp++;
            if (left == true) {
                while ((nums[end] >= number) && (start < end)) {//while the number 
//at the end is larger or equal to the stored number and the section is greater than 1
                    loop++;
                    comp++;
                    end--;//make the section smaller
                }
                nums[start] = nums[end];
                shift++;//set the number at the start to the number at the end,because it is no longer bigger
                left = false;
            } else {
                while ((nums[start] <= number) && (start < end)) {//while the numner
//at the start is smaller or equal to the stored number and the section is larger than 1
                    loop++;
                    comp++;
                    start++;//make the section smaller
                }
                shift++;
                nums[end] = nums[start];//set the number at the start to the end, because it is no longer smaller
                left = true;
            }
        }
        nums[start] = number;
        shift++;//place the stored number in the correct spot
        return start;//return this spot
    }
}
