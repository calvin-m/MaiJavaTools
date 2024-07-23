package MaiJavaTools.DataStructure;

import java.awt.*;
import java.util.*;
import java.util.List;

public class FindMinPathFrom2DArray {

    public static int[][] sampleMatrix = new int[][] {
            {1, 6, 6, 2}
            ,{4,5,1,2}
            ,{1,1,1,5}
    };
    // Define: matrix[row][col]
    //  Thus: point.x = col = matrix[row][point.x]
    //        point.y = row = matrix[point.y][col]

    public void printArray(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print( "[" + matrix[row][col] + "] ");
            }
            System.out.printf("%n"); // %n is OS independent new-line character instead of \n
        }
    }

    public void printPathAndCost(List<Point> path, int[][] matrix) {
        System.out.println("Path: ");
        int cost = 0;

        for (Point p : path) {
            System.out.printf("(%d, %d: %d) ", p.x, p.y, matrix[p.y][p.x]);
            cost += matrix[p.y][p.x];
        }

        System.out.println("Cost = " + cost);

    }

    public List<Point> findMinPath(Point start, Point end, int[][] matrix){
        List<Point> minPath = new ArrayList<Point>();
        //TIP: getLocation() returns a copy of the Point.
        //int minCost = topDownApproach(start.getLocation(), end.getLocation(), matrix, minPath); // recursive
        //System.out.println("topDownApproach(..) returns min cost: " + minCost);
        // return minPath;

        return bottomUpApproach(start, end, matrix);
        /*
        List<Point> minPath = new ArrayList<Point>();

        Point nextStep = start.getLocation();
        minPath.add(start);
        do{
            nextStep = getNextStep(nextStep, end, matrix);
            minPath.add(nextStep);
        } while (!nextStep.equals(end));

        return minPath;
        */
    }

    boolean baseCaseMet = false;
    Object lock = new Object();
    public int topDownApproach(Point start, Point current, int[][] matrix, List<Point> minPath) {
        //Recurrisve


        //minPath.add(current);

        Point p = current.getLocation(); // make a copy of current;

        // Define: matrix[row][col]
        //  Thus: point.x = col = matrix[row][point.x]
        //        point.y = row = matrix[point.y][col]

        Point p1, p2 = null;
        int c1, c2;
        if (p.getX() < start.getX() && p.getY() < start.getY()) {
            // have two options as next step: either (x+1, y) to go right or (x, y+1) to go down
            p1 = new Point(p.x + 1, p.y);
            p2 = new Point(p.x, p.y + 1);

            c1 = topDownApproach(start, p1, matrix, minPath);
            c2 = topDownApproach(start, p2, matrix, minPath);
            if(c1 < c2){
                minPath.add(p1);
                return matrix[p.y][p.x] + c1;
            }
            else{
                minPath.add(p2);
                return matrix[p.y][p.x] + c2;
            }

        } else if (p.getX() < start.getX() && p.getY() == start.getY()) {
            // can only go right: (x+1, y)
            p1 = new Point(p.x + 1, p.y);
            minPath.add(p1);
            return matrix[p.y][p.x] + topDownApproach(start, p1, matrix, minPath);
        } else if (p.getX() < start.getX() && p.getY() > start.getY()) {
            // two options as next step: either (x+1, y) to go right or (x, y-1) to go up
            p1 = new Point(p.x + 1, p.y);
            p2 = new Point(p.x, p.y - 1);

            c1 = topDownApproach(start, p1, matrix, minPath);
            c2 = topDownApproach(start, p2, matrix, minPath);
            if(c1 < c2){
                minPath.add(p1);
                return matrix[p.y][p.x] + c1;
            }
            else{
                minPath.add(p2);
                return matrix[p.y][p.x] + c2;
            }
        } else if (p.getX() == start.getX() && p.getY() < start.getY()) {
            // can only go down: (x, y+1)
            p1 = new Point(p.x, p.y+1);
            minPath.add(p1);
            return matrix[p.y][p.x] + topDownApproach(start, p1, matrix, minPath);
        } else if (p.getX() == start.getX() && p.getY() == start.getY()) {
            // Base case: arrived. return
            synchronized (lock) {
                if (!baseCaseMet) {
                    baseCaseMet = true;
                    minPath.add(start);
                }
            }
            return matrix[start.y][start.x];
        } else if (p.getX() == start.getX() && p.getY() > start.getY()) {
            // can only go up: (x, y-1)
            p1 = new Point(p.x, p.y-1);
            minPath.add(p1);
            return matrix[p.y][p.x] + topDownApproach(start, p1, matrix, minPath);
        } else if (p.getX() > start.getX() && p.getY() < start.getY()) {
            // two options as next step: either (x-1, y) to go left or (x, y+1) to do down
            p1 = new Point(p.x - 1, p.y);
            p2 = new Point(p.x, p.y + 1);

            c1 = topDownApproach(start, p1, matrix, minPath);
            c2 = topDownApproach(start, p2, matrix, minPath);
            if(c1 < c2){
                minPath.add(p1);
                return matrix[p.y][p.x] + c1;
            }
            else{
                minPath.add(p2);
                return matrix[p.y][p.x] + c2;
            }
        } else if (p.getX() > start.getX() && p.getY() == start.getY()) {
            // can only go left: (x-1, y)
            p1 = new Point(p.x-1, p.y);
            minPath.add(p1);
            return matrix[p.y][p.x] + topDownApproach(start, p1, matrix, minPath);
        } else if (p.getX() > start.getX() && p.getY() > start.getY()) {
            //two options as next step: either (x-1, y) to go left or (x, y-1) to go up
            p1 = new Point(p.x - 1, p.y);
            p2 = new Point(p.x, p.y - 1);

            c1 = topDownApproach(start, p1, matrix, minPath);
            c2 = topDownApproach(start, p2, matrix, minPath);
            if(c1 < c2){
                minPath.add(p1);
                return matrix[p.y][p.x] + c1;
            }
            else{
                minPath.add(p2);
                return matrix[p.y][p.x] + c2;
            }
        }
        return Integer.MAX_VALUE;
    }

    int min(Point p1, Point p2, int[][] matrix, List<Point> minPath){
        int cost = 0;
        for(Point p : minPath)
            cost += matrix[p.y][p.x];
        return 0;
    }

    List<Point> bottomUpApproach(Point start, Point end, int[][] matrix) {
        //Iterative
        //With an extra Cost matrix
        List<Point> minPath = new ArrayList<Point>();
        int[][] costs = new int[matrix.length][matrix[0].length];

        //Copy start's cost
        costs[start.y][start.x] = matrix[start.y][start.x];

        //Make copies of start and end
        Point p = start.getLocation();
        Point target = end.getLocation();

        // Define: matrix[row][col]
        //  Thus: point.x = col = matrix[row][point.x]
        //        point.y = row = matrix[point.y][col]
        int yRowOffset=0, xColOffset = 0;
        if (p.getX() < target.getX() && p.getY() < target.getY()) {
            // have two options as next step: either (x+1, y) to go right or (x, y+1) to go down
            xColOffset = 1;
            yRowOffset = 1;
        } else if (p.getX() < target.getX() && p.getY() == target.getY()) {
            // can only go right: (x+1, y)
            xColOffset = 1;
        } else if (p.getX() < target.getX() && p.getY() > target.getY()) {
            // two options as next step: either (x+1, y) to go right or (x, y-1) to go up
            xColOffset = 1;
            yRowOffset = -1;
        } else if (p.getX() == target.getX() && p.getY() < target.getY()) {
            // can only go down: (x, y+1)
            yRowOffset = 1;
        } else if (p.getX() == target.getX() && p.getY() == target.getY()) {
            // arrived. return the same point // do nothing
        }
        else if (p.getX() == target.getX() && p.getY() > target.getY()){
            // can only go up: (x, y-1)
            yRowOffset = -1;
        }
        else if(p.getX() > target.getX() && p.getY() < target.getY()){
            // two options as next step: either (x-1, y) to go left or (x, y+1) to do down
            xColOffset = -1;
            yRowOffset = 1;
        }
        else if(p.getX() > target.getX() && p.getY() == target.getY()){
            // can only go left: (x-1, y)
            xColOffset = -1;
        }
        else if(p.getX() > target.getX() && p.getY() > target.getY()){
            //two options as next step: either (x-1, y) to go left or (x, y-1) to go up
            xColOffset = -1;
            yRowOffset = -1;
        }

        // Horizontal row
        if(xColOffset > 0) { // going right
            for (int col = p.x + xColOffset; col <= target.x; col = col + xColOffset) {
                costs[p.y][col] = costs[p.y][col + xColOffset * -1] + matrix[p.y][col];
            }
        } else { //going left
            for (int col = p.x + xColOffset; col >= 0; col = col + xColOffset) {
                costs[p.y][col] = costs[p.y][col + xColOffset * -1] + matrix[p.y][col];
            }
        }

        // Vertical col
        if(yRowOffset > 0) { // going down
            for (int row = p.y + yRowOffset; row <= target.y; row = row + yRowOffset) {
                costs[row][p.x] = costs[row + yRowOffset * -1][p.x] + matrix[row][p.x];
            }
        } else { // going up
            for(int row = p.y+yRowOffset; row >= 0; row=row+yRowOffset){
                costs[row][p.x] = costs[row + yRowOffset * -1][p.x] + matrix[row][p.x];
            }
        }
        // then the rest of cells until hitting target/end
        int c1, c2;
        if(yRowOffset > 0) { // going down
            for (int row = p.y + yRowOffset; row <= target.y; row = row + yRowOffset) {
                if (xColOffset > 0) { // going left

                    for (int col = p.x + xColOffset; col <= target.x; col = col + xColOffset) {
                        c1 = costs[row + yRowOffset * -1][col];
                        c2 = costs[row][col + xColOffset * -1];
                        if (c1 < c2)
                            costs[row][col] = matrix[row][col] + c1;
                        else
                            costs[row][col] = matrix[row][col] + c2;
                    }
                } else {// going right
                    for (int col = p.x + xColOffset; col >= 0; col = col + xColOffset) {
                        c1 = costs[row + yRowOffset * -1][col];
                        c2 = costs[row][col + xColOffset * -1];
                        if (c1 < c2)
                            costs[row][col] = matrix[row][col] + c1;
                        else
                            costs[row][col] = matrix[row][col] + c2;
                    }
                }
            }
        } else { // going up
            for (int row = p.y + yRowOffset; row >= 0; row = row + yRowOffset) {
                if (xColOffset > 0) { // going right

                    for (int col = p.x + xColOffset; col <= target.x; col = col + xColOffset) {
                        c1 = costs[row + yRowOffset * -1][col];
                        c2 = costs[row][col + xColOffset * -1];
                        if (c1 < c2)
                            costs[row][col] = matrix[row][col] + c1;
                        else
                            costs[row][col] = matrix[row][col] + c2;
                    }
                } else {// going left
                    for (int col = p.x + xColOffset; col >= 0; col = col + xColOffset) {
                        c1 = costs[row + yRowOffset * -1][col];
                        c2 = costs[row][col + xColOffset * -1];
                        if (c1 < c2)
                            costs[row][col] = matrix[row][col] + c1;
                        else
                            costs[row][col] = matrix[row][col] + c2;
                    }
                }
            }
        }



        System.out.println("Costs matrix: ");
        this.printArray(costs);

        //Now find the min path from Costs
        Stack<Point> stack = new Stack<>();
        stack.push(end);
        int row=end.y, col=end.x, newRow, newCol;
        while (row != start.y || col != start.x){
            newRow = row + yRowOffset * -1;
            newCol = col + xColOffset * -1;

            if((yRowOffset > 0 && newRow >= start.y)
                || (yRowOffset < 0 && newRow <= start.y)){
                c1 = costs[newRow][col];
            }else
            {
                c1 = Integer.MAX_VALUE;
            }

            if((xColOffset > 0 && newCol >= start.x)
                || (xColOffset < 0 && newCol <= start.x)){
                c2 = costs[row][newCol];
            }
            else{
                c2 = Integer.MAX_VALUE;
            }


            if(c1 < c2){
                row = newRow;
            }
            else
            {
                col = newCol;
            }
            stack.push(new Point(col, row));
        }

        while (!stack.isEmpty()){
            minPath.add(stack.pop());
        }
        return minPath;
    }

}
