package Citadel;

public class findBeforeMatrix {

    /*
    s = 0
    for(i=0;i<=x;i++)
        for(j=0;j<=y;j++)
            s = s + before(i,j)

    */
    public static int[][] findBeforeMatrix(int n, int m, int[][] afterMatrix){
        //solved the row sum
        for(int i = 0; i < n; i++){
            for(int j = m - 1 ; j >= 1; j--){
                afterMatrix[i][j] -= afterMatrix[i][j-1];
            }
        }
        //solve the col sum
        for(int i = n - 1; i >= 1; i--){
            for(int j = 0; j < m; j++){
                afterMatrix[i][j] -= afterMatrix[i-1][j];
            }
        }
        return afterMatrix;
    }

    public static void main(String[] args) {
        int[][] after = {{2,5}, {7,17}};
        int[][] before = findBeforeMatrix(2, 2, after);
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(before[i][j] + " ");
            }
            System.out.println();
        }
    }
}
