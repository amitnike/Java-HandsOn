package com.amit.handson.adv_greedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//There are N jobs to be done, but you can do only one job at a time.
//
//Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
//
//Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
//
//Return the maximum number of jobs you can finish.
public class FinishMaxJobs {
    public int solve(int[] A, int[] B) {
        int ans=1;
        ArrayList<Activity> list=new ArrayList<Activity>();
        for(int i=0;i<B.length;i++){
            list.add(new Activity(A[i],B[i]));
        }
        Collections.sort(list,new CustomComparator());
        int current_end=list.get(0).end;
        for(int i=1;i<list.size();i++){
            if(list.get(i).start>=current_end){
                ans++;
                current_end=list.get(i).end;
            }
        }
        return ans;
    }

    class Activity{
        int start;
        int end;
        public Activity(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    class CustomComparator implements Comparator<Activity> {

        public int compare(Activity a, Activity b)
        {
            return a.end-b.end;
        }
    }
}
