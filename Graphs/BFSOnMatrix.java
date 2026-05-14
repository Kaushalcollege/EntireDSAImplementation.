
import java.util.*;
// import java.util.List;

public class BFSOnMatrix {
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
                    bfs4(grid, vis4, x, y, m, n);
                }
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!vis8[x][y] && grid[x][y] == '1') {

                    cnt8++;
                    bfs8(grid, vis8, x, y, m, n);
                }
            }
        }

        return new int[]{cnt4, cnt8};
    }

    private static void bfs4 (char[][] grid, boolean[][] v, int x, int y, int m, int n) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        v[x][y] = true;
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            // v[curr[0]][curr[1]] = true;

            // int[] dr = {0, 0, -1, 1};
            // int[] dc = {-1, 1, 0, 0};

            // for (int i = 0; i < 4; i++) q.add(new int[]{x + dr[i], y + dc[i]});

            int r = curr[0]; // current row
            int c = curr[1]; // current column

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nc >= 0 && nr >= 0 && nc < n && nr < m && grid[nr][nc] == '1' && !v[nr][nc]) {
                    v[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static void bfs8 (char[][] grid, boolean[][] v, int x, int y, int m, int n) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        v[x][y] = true;
        // 8 directions
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0]; // current row
            int c = curr[1]; // current column

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nc >= 0 && nr >= 0 && nc < n && nr < m && grid[nr][nc] == '1' && !v[nr][nc]) {
                    v[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}