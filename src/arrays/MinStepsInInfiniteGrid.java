package arrays;

import java.util.ArrayList;

/*
 * Min Steps in Infinite Grid
You are in an infinite 2D grid where you can move in any of the 8 directions
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.

Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
Output Format
Return an Integer, i.e minimum number of steps.


Example Input
Input
A = [0, 1, 1]
B = [0, 1, 2]
Output: 2
Explanation:
Given three points are: (0, 0), (1, 1) and (1, 2).
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

 */

public class MinStepsInInfiniteGrid {

	public static void main(String[] args) {
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		X.add(0);
		X.add(1);
		X.add(1);
		Y.add(0);
		Y.add(1);
		Y.add(2);
		System.out.println(new MinStepsInInfiniteGrid().coverPoints(X, Y));

	}
	
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int result =0;
        if((X.size() == Y.size()) && X.size() > 1){
            for(int i=0;i<(X.size()-1);i++){
                result = result + distance(X.get(i),Y.get(i),X.get(i+1),Y.get(i+1));
            }
        }
        return result;
    }
	
    int distance(int x1,int y1,int x2,int y2){
        if(x2==x1){
            return Math.abs(y2-y1);
        }
        else if(y2==y1){
            return Math.abs(x2-x1);
        }
        else{
            if((x2-x1)>0){
                if((y2-y1)>0){
                    return (distance(x1+1,y1+1,x2,y2)+1);
                }
                else {
                    return (distance(x1+1,y1-1,x2,y2)+1);
                }
            }
            else {
                if((y2-y1)>0){
                    return (distance(x1-1,y1+1,x2,y2)+1);
                }
                else {
                    return (distance(x1-1,y1-1,x2,y2)+1);
                }
            }

        }
    }

}
