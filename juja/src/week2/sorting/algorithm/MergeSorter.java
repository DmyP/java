package week2.sorting.algorithm;

import week2.sorting.Array;
import week2.sorting.ArrayImpl;
import week2.sorting.Sorter;

public class MergeSorter implements Sorter {

    private Array array;
    private Array tempMergeArr;
    private int length;

    @Override
    public void sort(Array data) {
        array = data;
        length = data.size();
        tempMergeArr = new ArrayImpl(new int[length]);
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeArr.set(i, array.get(i));
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergeArr.get(i).compareTo(tempMergeArr.get(j)) <= 0) {
                array.set(k, tempMergeArr.get(i));
                i++;
            } else {
                array.set(k, tempMergeArr.get(j));
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array.set(k, tempMergeArr.get(i));
            k++;
            i++;
        }

    }
}
