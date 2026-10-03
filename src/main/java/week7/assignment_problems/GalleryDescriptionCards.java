package week7.assignment_problems;

abstract class ArtPiece {
    private static int counter = 0;
    private final String pieceId;

    ArtPiece() {
        counter++;
        pieceId = "PIECE-" + counter;
    }

    public String getPieceId() {
        return pieceId;
    }

    public abstract String describe();
}

class Painting extends ArtPiece {
    @Override
    public String describe() {
        return "Painting: A framed artwork with colors and brush strokes";
    }
}

class Sculpture extends ArtPiece {
    @Override
    public String describe() {
        return "Sculpture: A three-dimensional artwork";
    }
}

public class GalleryDescriptionCards {

    public static void main(String[] args) {
        ArtPiece painting = new Painting();
        ArtPiece sculpture = new Sculpture();

        System.out.println(painting.getPieceId());
        System.out.println(painting.describe());

        System.out.println(sculpture.getPieceId());
        System.out.println(sculpture.describe());
    }
}