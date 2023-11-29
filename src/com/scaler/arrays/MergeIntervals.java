package com.scaler.arrays;

import java.util.ArrayList;

public class MergeIntervals {
    public static void main(String[] args) {

    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.start = newInterval.start > interval.start ? interval.start : newInterval.start;
                newInterval.end = newInterval.end < interval.end ? interval.end : newInterval.end;
            }
        }
        result.add(newInterval);
        return result;
    }

}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
