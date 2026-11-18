package engine.dto;

import java.util.List;
import jakarta.validation.constraints.NotNull;

public record SolveRequest(@NotNull List<@NotNull Integer> answer) { }
