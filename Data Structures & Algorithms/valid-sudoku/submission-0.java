class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = (HashSet<Character>[]) new HashSet[9];
        HashSet<Character>[] columns = (HashSet<Character>[]) new HashSet[9];
        HashSet<Character>[] grids = (HashSet<Character>[]) new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            grids[i] = new HashSet<Character>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                if (rows[i].contains(c))
                    return false;
                if (columns[j].contains(c))
                    return false;
                int gridIdx = i / 3 + 3 * (j / 3);
                if (grids[gridIdx].contains(c))
                    return false;

                rows[i].add(c);
                columns[j].add(c);
                grids[gridIdx].add(c);
            }
        }
        return true;
    }
}
