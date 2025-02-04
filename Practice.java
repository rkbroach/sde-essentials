import java.util.List;
import java.util.ArrayList;

public class Minesweeper {
    private final List<String> board;

    public Minesweeper(List<String> inputBoard) {
        this.board = inputBoard;
    }

    public List<String> withNumbers() {
        int rows = board.size();
        if (rows == 0) return board;
        int cols = board.get(0).length();
        char[][] updatedBoard = new char[rows][cols];

        // Initialize board
        for (int i = 0; i < rows; i++) {
            updatedBoard[i] = board.get(i).toCharArray();
        }

        // Iterate and calculate mine counts
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (updatedBoard[r][c] == '*') continue;
                updatedBoard[r][c] = countMines(updatedBoard, r, c, rows, cols);
            }
        }

        // Convert back to List<String>
        List<String> result = new ArrayList<>();
        for (char[] row : updatedBoard) {
            result.add(new String(row));
        }
        return result;
    }

    private char countMines(char[][] board, int r, int c, int rows, int cols) {
        int count = 0;
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == '*') {
                count++;
            }
        }
        return count == 0 ? ' ' : (char) ('0' + count);
    }
}

//////////////////////////////////////

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class MinesweeperTest {

    @Test
    void testSingleRow() {
        List<String> input = List.of("*  ");
        List<String> expected = List.of("*1 ");
        assertEquals(expected, new Minesweeper(input).withNumbers());
    }

    @Test
    void testSingleColumn() {
        List<String> input = List.of(" ", " ", "*", " ");
        List<String> expected = List.of(" ", "1", "*", "1");
        assertEquals(expected, new Minesweeper(input).withNumbers());
    }

    @Test
    void testMultipleRowsColumns() {
        List<String> input = List.of(
                "  *  ",
                "     ",
                "*****",
                "  *  ",
                "     "
        );

        List<String> expected = List.of(
                " 2*2 ",
                "25*52",
                "*****",
                "25*52",
                " 2*2 "
        );

        assertEquals(expected, new Minesweeper(input).withNumbers());
    }
}

