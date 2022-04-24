package merge;

import java.util.ArrayList;
import java.util.List;

public class Mergesort<T extends Comparable<T>> {
    public void MergeSort(T[] arr, int p, int r) {
        if (p >= r) return;
        int q = ((p + r) / 2);
        MergeSort(arr, p, q);
        MergeSort(arr, q + 1, r);
        Merge(arr, p, q, r);
    }

    public void MergeSortYT(List<T> arr) {
        int n = arr.size();
        if (n < 2) return;
        int m = n / 2;
        List<T> L = new ArrayList<>();
        List<T> R = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            L.add(arr.get(i));
        }
        for (int i = m; i < arr.size(); i++) {
            R.add(arr.get(i));
        }
        MergeSortYT(L);
        MergeSortYT(R);
        MergeYT(arr, L, R);
    }

    private void MergeYT(List<T> arr, List<T> L, List<T> R) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < L.size() && j < R.size()) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }
        while (i < L.size()) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < R.size()) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    private void Merge(T[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        List<T> L = new ArrayList<>();
        List<T> R = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            L.add(arr[p + i]);
        }
        for (int j = 0; j < n2; j++) {
            R.add(arr[q + j + 1]);
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
                arr[k] = L.get(i);
                i++;
            } else {
                arr[k] = R.get(j);
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L.get(i);
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R.get(j);
            j++;
            k++;
        }
    }
}
