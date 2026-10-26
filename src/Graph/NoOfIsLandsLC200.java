package Graph;
import java.util.*;
public class NoOfIsLandsLC200 {
    public static void dfs(char[][] grid, boolean[][] vis, int rows, int cols){
        int r = grid.length;
        int c = grid[0].length;

        if(rows < 0 || cols < 0 || rows >= r || cols >= c || grid[rows][cols] == '0' || vis[rows][cols]){
            return;
        }

        vis[rows][cols] = true;
        dfs(grid, vis, rows-1, cols);
        dfs(grid, vis, rows + 1, cols);
        dfs(grid, vis, rows, cols - 1);
        dfs(grid, vis, rows, cols + 1);
    }

    public static int noIslands(char[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        int ans = 0;
        boolean[][] vis = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == '1' && !vis[i][j]){
                    ans++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        int ans = noIslands(grid);
        System.out.println(ans);
    }
}
