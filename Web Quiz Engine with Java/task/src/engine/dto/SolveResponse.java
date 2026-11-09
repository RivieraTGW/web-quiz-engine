package engine.dto;

public record SolveResponse(boolean success, String feedback) {

    public static SolveResponse correct() {
        return new SolveResponse(true, "Congratulations, you're right!");
    }

    public static SolveResponse wrong() {
        return new SolveResponse(false, "Wrong answer! Please, try again.");
    }
}
