package com.muric.com.muric.elimination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Elimination {
    /**
     * Given an array of integers start eliminating every N-th element.
     * When reach the end of array, start over from the beginning.
     * @param array of integers
     * @param everyNth index of every Nth element to eliminate
     * @return last element left after elimination
     */
    public static int[] eliminateEveryNelement(int[] array, int everyNth){
        if(array.length == 0 || everyNth < 0){
            throw new IllegalArgumentException("Cannot accept metod's arguments - array.length = " +
                array.length + ", everyNth = " + everyNth);
        }
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new)));

        if(everyNth <= queue.size() || queue.size() != 1){
            int index = 0;
            while(index <queue.size()){
                if(null != queue.peek()) {
                    if (index < everyNth) {
                        queue.add(queue.poll());
                        index++;
                    } else {
                        queue.remove();
                        index = 0;
                    }
                }
            }
        }

        return queue.stream().mapToInt(ii->ii).toArray();
    }
}
