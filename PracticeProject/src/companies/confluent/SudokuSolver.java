package companies.confluent;

class SudokuSolver {
    private char[][] b;
    private final boolean[][] rowUsed = new boolean[9][10]; // rowUsed[r][d]
    private final boolean[][] colUsed = new boolean[9][10]; // colUsed[c][d]
    private final boolean[][] boxUsed = new boolean[9][10]; // boxUsed[box][d]

    public void solveSudoku(char[][] board) {

        b = board;

        // Initialize usage tables from the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (b[r][c] != '.') {
                    int d = b[r][c] - '0';
                    rowUsed[r][d] = true;
                    colUsed[c][d] = true;
                    boxUsed[boxIndex(r, c)][d] = true;
                }
            }
        }
        dfs();
    }

    private boolean dfs() {
        // Find the empty cell with the fewest candidates
        int bestR = -1, bestC = -1, bestCount = 10;
        boolean foundEmpty = false;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (b[r][c] == '.') {
                    foundEmpty = true;
                    int cnt = 0;

                    for (int d = 1; d <= 9; d++) {
                        if (canPlace(r, c, d))
                            cnt++;
                    }

                    if (cnt == 0)
                        return false; // dead end

                    if (cnt < bestCount) {
                        bestCount = cnt;
                        bestR = r; bestC = c;
                        if (cnt == 1)
                            break;
                    }
                }
            }
            if (bestCount == 1)
                break;
        }

        if (!foundEmpty)
            return true; // solved

        int r = bestR, c = bestC;
        for (int d = 1; d <= 9; d++) {
            if (canPlace(r, c, d)) {
                place(r, c, d);
                if (dfs())
                    return true;
                remove(r, c, d);
            }
        }
        return false; // backtrack
    }

    private boolean canPlace(int r, int c, int d) {
        return !rowUsed[r][d] && !colUsed[c][d] && !boxUsed[boxIndex(r, c)][d];
    }

    private void place(int r, int c, int d) {
        b[r][c] = (char) ('0' + d);
        rowUsed[r][d] = true;
        colUsed[c][d] = true;
        boxUsed[boxIndex(r, c)][d] = true;
    }

    private void remove(int r, int c, int d) {
        b[r][c] = '.';
        rowUsed[r][d] = false;
        colUsed[c][d] = false;
        boxUsed[boxIndex(r, c)][d] = false;
    }

    private int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}

