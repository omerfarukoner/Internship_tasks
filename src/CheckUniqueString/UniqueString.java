/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckUniqueString;

import java.util.*;

/**
 *
 * @author Omerfaruk
 */
public class UniqueString {

    public static String[] mergeSort(String[] list) {
        String[] sorted = new String[list.length];
        if (list.length == 1) {
            sorted = list;
        } else {
            int mid = list.length / 2;
            String[] left = null;
            String[] right = null;
            if ((list.length % 2) == 0) {
                left = new String[list.length / 2];
                right = new String[list.length / 2];
            } else {
                left = new String[list.length / 2];
                right = new String[(list.length / 2) + 1];
            }
            int x = 0;
            int y = 0;
            for (; x < mid; x++) {
                left[x] = list[x];
            }
            for (; x < list.length; x++) {
                right[y++] = list[x];
            }
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = mergeArray(left, right);
        }

        return sorted;
    }

    private static String[] mergeArray(String[] left, String[] right) {
        String[] merged = new String[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        int comp = 0;
        while (lIndex < left.length || rIndex < right.length) {
            if (lIndex == left.length) {
                merged[mIndex++] = right[rIndex++];
            } else if (rIndex == right.length) {
                merged[mIndex++] = left[lIndex++];
            } else {
                comp = left[lIndex].compareTo(right[rIndex]);
                if (comp > 0) {
                    merged[mIndex++] = right[rIndex++];
                } else if (comp < 0) {
                    merged[mIndex++] = left[lIndex++];
                } else {
                    merged[mIndex++] = left[lIndex++];
                }
            }
        }
        return merged;
    }

    public boolean uniqueCharacters(String str) {
        //While I was coding,I tried to not use the ready functions such as arraylist,toChar as far as possible. 
        //As I wanted to code differently from 	first thing come to mind.I took the merge sort code from internet directly.
        
        str = str.toLowerCase();//All characters were made the same level

        String[] arr = str.split("");//Split string to char
        String[] arr_sorted = mergeSort(arr);//Sorted list to improve the comparison's efficiency 
        String[] arr_dub = new String[arr.length];//Dublicated elements' maximum can be as much as array's length 

        int flag = 0;//Defines if the string is unique.I used flag because I checks all dublicated char and holds them in arr_dub
        int i = 0;
        int counter_dub = 0;//Holds number of dublicated char.
        while (i < arr_sorted.length - 1) {

            if (arr_sorted[i].equals(arr_sorted[i + 1])) {
                flag = 1;//If I do not check the all unique char,I could break the loop,so I need a flag.
                arr_dub[counter_dub] = arr_sorted[i];//Holds dublicated in an array because dublicated chars will be deleted later.
                counter_dub++;
            }
            i++;
        }

        if (flag == 1) {
            System.out.println("'" + str + "'" + " has dublucated characters ");

            for (int a = 0; a < counter_dub; a++) {//Loop goes on by number of dublicated char
                str = str.replaceFirst(arr_dub[a], "");//Deletes dublicated
            }
            System.out.println("Deleted Dublicated Version :" + "'" + str + "'");

            return false;
        } else {
            System.out.println("'" + str + "'"  + " has unique characters ");
            return true;
        }

    }

}
