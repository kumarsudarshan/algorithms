package heap.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
'K' Closest Points to the Origin (easy)
Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.
Input: points = [[1,2],[1,3]], K = 1
Output: [[1,2]]
Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
The Euclidean distance between (1, 3) and the origin is sqrt(10).
Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
Output: [[1, 3], [2, -1]]
 */
public class KClosetPointsToOrigin {
    public static void main(String[] args) {
        List<Point> points = kClosetPoints(new Point[]{new Point(1, 2), new Point(1, 3)}, 1);
        points.forEach(p -> System.out.println("[" + p.x + ", " + p.y + "]"));
        points = kClosetPoints(new Point[]{new Point(1, 3), new Point(3, 4), new Point(2, -1)}, 2);
        points.forEach(p -> System.out.println("[" + p.x + ", " + p.y + "]"));
    }

    public static List<Point> kClosetPoints(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((a, b) -> b.distFromOrigin() - a.distFromOrigin());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }
        return new ArrayList<>(maxHeap);
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignore sqrt
        return x * x + y * y;
    }
}