package practice.LowLevelDesign.ChessGame;

import practice.LowLevelDesign.ChessGame.enums.GameStatus;
import practice.LowLevelDesign.ChessGame.pieces.Piece;

import java.util.List;

public class Chess {

    private ChessBoard chessBoard;
    private Player[] players;
    private Player currentPlayer;
    private List<Move> movesList;
    private GameStatus gameStatus;

    public boolean playerMove(CellPosition fromPosition, CellPosition toPosition, Piece piece){return false;}

    public boolean endGame() {return false;}

    private void changeTurn() {}

}
