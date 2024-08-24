package operatorOverloadingAndOverConventions.arithmeticOperations;

public class PointJava {

    private final Integer x;
    private final Integer y;

    public PointJava(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public PointJava plus(PointJava other) {
        return new PointJava(this.x + other.x, this.y + y);
    }

    @Override
    public String toString() {
        return x.toString().concat(" ").concat(y.toString());
    }
}
