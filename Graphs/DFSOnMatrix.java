
import java.util.*;
// import java.util.List;

public class DFSOnMatrix {
    public static void main(String[] args) {
        // This is Number of Islands code ::
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        char[][] testGrid = {
            {'1', '1', '1', '0', '1'},
            {'1', '0', '0', '0', '0'},
            {'1', '1', '1', '0', '1'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(Arrays.toString(numberOfIslands(grid)));
        System.out.println();
        System.out.println(Arrays.toString(numberOfIslands(testGrid)));
    }

    private static int[] numberOfIslands(char[][] grid) {
        // We are working for both 4 and 8 directions ::
        int m = grid.length, n = grid[0].length;

        boolean[][] vis4 = new boolean[m][n];
        boolean[][] vis8 = new boolean[m][n];
        int cnt4 = 0, cnt8 = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!vis4[x][y] && grid[x][y] == '1') {

                    cnt4++;
                    dfs4(grid, vis4, x, y, m, n);
                }
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!vis8[x][y] && grid[x][y] == '1') {

                    cnt8++;
                    dfs8(grid, vis8, x, y, m, n);
                }
            }
        }

        return new int[]{cnt4, cnt8};
    }

    private static void dfs4 (char[][] grid, boolean[][] v, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0' || v[x][y]) return;

        v[x][y] = true;

        //Up
        dfs4 (grid, v, x - 1, y, m, n);
        //Down
        dfs4 (grid, v, x + 1, y, m, n);
        //right
        dfs4 (grid, v, x, y + 1, m, n);
        //left
        dfs4 (grid, v, x, y - 1, m, n);

        return;
    }

    private static void dfs8 (char[][] grid, boolean[][] v, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0' || v[x][y]) return;

        v[x][y] = true;

        // 8 directions
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {

            int nr = x + dr[k];
            int nc = y + dc[k];

            dfs8(grid, v, nr, nc, m, n);
        }

        return;
    }
}