package com.premiumminds.internship.mousepath;
import java.util.*;

class MousePathService implements IMousePathService {
    // can only be '-', '|', or '+' (corner)
    @Override
    public boolean isValidGrid(char[][] grid) {
        // null or empty grid -> invalid
        if (grid == null || grid.length == 0) return false;

        int rows = grid.length, cols = grid[0].length;
        List<int[]> endpoints = new ArrayList<>();
        Set<String> segments = new HashSet<>();

        // scan grid: collect endpoints and line segments
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = grid[i][j];
                if (c == 'X') {
                    endpoints.add(new int[]{i, j});
                } else if (c == '-' || c == '|' || c == '+') {
                    segments.add(key(i, j));
                } else if (c == ' ' || c == 0) {
                    // pass
                } else {
                    // invalid
                    return false;
                }
            }
        }

        // must have two ends
        if (endpoints.size() != 2) return false;

        // combine endpoints and segments into full path set
        Set<String> all = new HashSet<>(segments);
        String start = key(endpoints.get(0)[0], endpoints.get(0)[1]);
        String end = key(endpoints.get(1)[0], endpoints.get(1)[1]);
        all.add(start);
        all.add(end);

        // build adjacency for each path cell
        Map<String, List<String>> adjacency = new HashMap<>();
        for (String cell : all) {
            String[] parts = cell.split(",");
            int i = Integer.parseInt(parts[0]), j = Integer.parseInt(parts[1]);
            char c = grid[i][j];
            List<String> neighbors = new ArrayList<>();

            // check four directions for valid neighbor
            for (int[] d : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}) {
                int ni = i + d[0], nj = j + d[1];
                String key = key(ni, nj);
                if (ni < 0 || nj < 0 || ni >= rows || nj >= cols) continue;
                if (all.contains(key)) neighbors.add(key);
            }
            adjacency.put(cell, neighbors);

            int degree = neighbors.size();
            boolean isEndpoint = cell.equals(start) || cell.equals(end);

            // endpoints must have one connection and segments must have two
            if (isEndpoint) {
                if (degree != 1) return false;
            } else {
                if (degree != 2) return false;

                // orientation checks
                if (c == '-') {
                    // must connect left and right
                    if (!(has(neighbors, i, j-1) && has(neighbors, i, j+1))) return false;
                } else if (c == '|') {
                    // must connect up and down
                    if (!(has(neighbors, i-1, j) && has(neighbors, i+1, j))) return false;
                } else if (c == '+') {
                    // corner must have one horizontal and one vertical
                    boolean horiz = has(neighbors, i, j-1) || has(neighbors, i, j+1);
                    boolean vert  = has(neighbors, i-1, j) || has(neighbors, i+1, j);
                    if (!(horiz && vert)) return false;
                }
            }
        }

        // from start must cover all path cells
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String nb : adjacency.get(cur)) {
                if (!visited.contains(nb)) {
                    visited.add(nb);
                    queue.add(nb);
                }
            }
        }

        return visited.size() == all.size();
    }

    // encode coordinates
    private static String key(int i, int j) {
        return i + "," + j;
    }

    // check if neighbors list contains provided coordinate
    private static boolean has(List<String> neigh, int i, int j) {
        return neigh.contains(key(i, j));
    }
}
