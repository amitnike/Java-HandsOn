package com.amit.handson.adv_greedyAlgo;

//Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
//
//B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
//
//Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
//
//NOTE:
//
//You can start buying from time = 0.
//Return your answer modulo 109 + 7.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//Input 1:
//
// A = [1, 3, 2, 3, 3]
// B = [5, 6, 1, 3, 9]
//Input 2:
//
// A = [3, 8, 7, 5]
// B = [3, 1, 7, 19]
//
//
//Example Output
//Output 1:
//
// 20
//Output 2:
//
// 30
public class FreeCars {

    public static void main(String[] args){
        int[] A = new int[]{1, 7, 6, 2, 8, 4, 4, 6, 8, 2};
        int[] B = new int[]{8, 11, 7, 7, 10, 8, 7, 5, 4, 9};
        FreeCars dc = new FreeCars();
        System.out.println(dc.solve(A,B));
    }

    public int solve(int[] A, int[] B) {
        int mod = 1000000007;
        ArrayList<CarSelection> list=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<A.length;i++){
            list.add(new CarSelection(A[i],B[i]));
        }
        Collections.sort(list,new CarSelectionCompator());

        int startTime = 1;
        for(int i=0;i<list.size();i++){
            //if  current time is greater or equal to starttime
            CarSelection current = list.get(i);
            if(current.time >=startTime){
                //get the reward for that time and increase the time
                    pq.offer(current.profit);
                    startTime++;
            } else {
                //check if new reward is greater than min in the heap
                if(current.profit > pq.peek()){
                    //if yes, remove that min and add the new higher reward
                    pq.remove();
                    pq.offer(current.profit);
                }
            }

        }

        int sum = 0;
        while(!pq.isEmpty()){
            sum = (sum%mod)+(pq.remove()%mod);
        }

        return sum%mod;
    }

    class CarSelection{
        int time;
        int profit;
        public CarSelection(int time,int profit){
            this.time=time;
            this.profit=profit;
        }
    }
    class CarSelectionCompator implements Comparator<CarSelection> {

        public int compare(CarSelection a, CarSelection b)
        {
            return a.time-b.time;
        }
    }
}
