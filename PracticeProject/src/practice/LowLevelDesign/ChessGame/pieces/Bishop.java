package practice.LowLevelDesign.ChessGame.pieces;

import practice.LowLevelDesign.ChessGame.CellPosition;

import java.util.List;

public class Bishop extends Piece {

    boolean move(CellPosition fromPosition, CellPosition toPosition) {return false;}

    List<CellPosition> possibleMoves(CellPosition fromPosition) { return null; }

    boolean validate(CellPosition fromPosition, CellPosition toPosition) {return false;}
}
