package MaiJavaTools.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder2DArray {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        int lOffset = 0, rOffset=0, uOffset=0, dOffset=0;
        int row=0, col=0;
        char dir = 'R';// 'D', 'L', 'U'

        while(true){
            if(dir == 'R'){
                if(col < matrix[0].length - rOffset){
                    result.add(matrix[row][col]);
                    col++;
                } else { // change direction
                    uOffset++; // finished one row on top
                    dir = 'D';
                    row++; // go to next row
                    col--; // step back to valid range

                    //check if done
                    if(row >= (matrix.length - dOffset))
                        break;
                }
            } else if (dir == 'D'){
                if(row < (matrix.length - dOffset)){
                    result.add(matrix[row][col]);
                    row++;
                } else { //change direction
                    rOffset++; // finished one col on the right
                    dir = 'L';
                    col--; // go to left
                    row--; // step back to valid range

                    //check if done
                    if(col < lOffset)
                        break;
                }

            } else if (dir == 'L'){
                if(col >= lOffset){
                    result.add(matrix[row][col]);
                    col--;
                } else { // check direction
                    dOffset++; // finished one row on the bottom
                    dir = 'U';
                    row--; // go up one row
                    col++; // step back to valid range

                    //check if done
                    if(row < uOffset)
                        break;
                }

            } else if (dir == 'U'){
                if(row >= uOffset){
                    result.add(matrix[row][col]);
                    row--;
                } else { // change direction
                    lOffset++; // finished one col from the left
                    dir = 'R';
                    col++; // to go right one step
                    row++; // step back to valid range

                    //check if done
                    if(col >= matrix[row].length - rOffset)
                        break;
                }
            }
        }

        return result;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
}
