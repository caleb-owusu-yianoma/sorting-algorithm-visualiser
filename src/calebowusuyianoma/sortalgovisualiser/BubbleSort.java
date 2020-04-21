package calebowusuyianoma.sortalgovisualiser;

import java.util.ArrayList;

public class BubbleSort {
    private boolean isRunning = false, justRanSwap = false, sorted = false;
    private int i = 0, j = 0;

    public int[] getPointers() {
        return new int[] {i, j};
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean justRanSwap() {
        return justRanSwap;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void adjustPointers(ArrayList<Integer> data) {
        if (j == 0) {
            j = data.size() - 1;
            isRunning = true;
        } else if (j > i + 1) {
            j--;
            justRanSwap = false;
        } else if (i < data.size() - 1) {
            i++;
            j = data.size() - 1;
            justRanSwap = false;
        } else {
            sorted = true;
        }
    }

    public void sort(ArrayList<Integer> data) {
        if (data.isEmpty()) {
            return;
        }

        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = data.size() - 1; j > i; j--) {
                if (data.get(j) < data.get(j - 1)) {
                    swap(data, j);
                }
            }
        }
    }

    public void swap(ArrayList<Integer> data) {
        if (data.get(j) < data.get(j - 1)) {
            swap(data, j);
        }
        justRanSwap = true;
    }

    private void swap(ArrayList<Integer> data, int index) {
        int temp = data.get(index);
        data.set(index, data.get(index - 1));
        data.set(index - 1, temp);
    }
}