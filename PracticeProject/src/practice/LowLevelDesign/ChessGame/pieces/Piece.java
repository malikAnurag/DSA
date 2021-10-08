package practice.LowLevelDesign.ChessGame.pieces;

import practice.LowLevelDesign.ChessGame.CellPosition;
import practice.LowLevelDesign.ChessGame.enums.Color;

import java.util.List;

public abstract class Piece {

    Color color;

    abstract boolean move(CellPosition fromPosition, CellPosition toPosition) ;

    abstract List<CellPosition> possibleMoves(CellPosition fromPosition);

    abstract boolean validate(CellPosition fromPosition, CellPosition toPosition) ;
}
