package br.com.chesssystemjava.chess;

import br.com.chesssystemjava.boardgame.Board;
import br.com.chesssystemjava.boardgame.Piece;
import br.com.chesssystemjava.boardgame.Position;
import lombok.Getter;

public abstract class ChessPiece extends Piece {

    @Getter
    private Color color;

    @Getter
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public void decreaseMoveCount() {
        moveCount--;
    }

}
