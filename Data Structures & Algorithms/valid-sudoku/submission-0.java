class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    continue;
                }

                char num = board[row][col];

                // Row
                String rowKey = num + " in row " + row;

                // Column
                String colKey = num + " in col " + col;

                // 3x3 box
                int box = (row / 3) * 3 + (col / 3);
                String boxKey = num + " in box " + box;

                // Duplicate found
                if (!set.add(rowKey) ||
                    !set.add(colKey) ||
                    !set.add(boxKey)) {

                    return false;
                }
            }
        }

        return true;
    }
}