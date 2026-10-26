package Graph;
import java.util.*;
public class FloodFillLC733 {
    public static void dfs(int[][] image, int rows, int cols, int oldC, int newC){
        int r = image.length;
        int c = image[0].length;

        if(rows < 0 || cols < 0 || rows >= r || cols >= c || image[rows][cols] != oldC){
            return;
        }

        image[rows][cols] = newC;
        dfs(image, rows - 1, cols, oldC, newC);
        dfs(image, rows + 1, cols, oldC, newC);
        dfs(image, rows, cols - 1, oldC, newC);
        dfs(image, rows, cols + 1, oldC, newC);
    }

    public static int[][] floodFill(int[][] images, int sr, int sc, int newC){
        int oldC = images[sr][sc];

        if(oldC == newC) return images;

        dfs(images, sr, sc, oldC, newC);

        return images;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] images = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                images[i][j] = sc.nextInt();
            }
        }

        int sr = sc.nextInt();
        int sC = sc.nextInt();

        int newC = sc.nextInt();

        int[][] ans = floodFill(images, sr, sC, newC);

        for(int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
