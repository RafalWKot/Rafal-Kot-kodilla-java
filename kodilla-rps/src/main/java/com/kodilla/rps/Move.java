package com.kodilla.rps;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Move {
    private String moveName;
    private List<String> winWith;
    private List<String> loseWith;
}
