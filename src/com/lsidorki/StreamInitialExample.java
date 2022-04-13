package com.lsidorki;

import com.lsidorki.dto.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 4
public class StreamInitialExample {
    private static final String CITY = "Gdynia";
    private static final Logger LOGGER = Logger.getLogger(StreamInitialExample.class.getName());

    public static void main(String[] args) {
        List<Player> playerListA = List.of(
                new Player("Wojciech", "Adamski", "Warszawa", 3),
                new Player("Jan", "Kowalski", "Wrocław", 4),
                new Player("Marcin", "Malinowski", "Opole",2),
                new Player("Tomasz", "Wiśniewski", "Wrocław", 5)
        );

        List<Player> playerListB = List.of(
                new Player("Maria", "Adamska", "Warszawa", 3),
                new Player("Beata", "Kowalska", "Wrocław", 7),
                new Player("Aleksandra", "Malinowska", "Opole", 4),
                new Player("Katarzyna", "Wiśniewska", "Wrocław", 6)
        );

        streamBasicExample(playerListA);
        mapExample(playerListA);
        flatMapExample(playerListA, playerListB);
        minMaxExample(playerListA, playerListB);
        reduceAccumulatorExample(playerListA);
        reduceExample(playerListA);
    }

    private static void streamBasicExample(List<Player> playerListA) {
        long playersFromWroclaw = playerListA
                .stream()
                .filter(player -> {
                    LOGGER.log(Level.INFO, "Checking player: {0}", player.getLastName());
                    return player.isFrom(CITY);
                }).count();
        LOGGER.log(Level.INFO,"Players from Wroclaw: {0}", playersFromWroclaw);
    }

    private static void reduceExample(List<Player> playerListA) {
        Integer countGoals = playerListA.stream()
                .map(player -> player.getGoals())
                .reduce(0, (acc, element) -> acc + element);
        LOGGER.log(Level.INFO, "Goals Scored reduce: {0}", countGoals);
    }

    private static void reduceAccumulatorExample(List<Player> playerListA) {
        int accumulator = 0;
        for(Player element : playerListA) {
            accumulator = accumulator + element.getGoals();
        }
        LOGGER.log(Level.INFO, "Goals Scored: {0}", accumulator);
    }

    private static void minMaxExample(List<Player> playerListA, List<Player> playerListB) {
        Optional<Player> worstPlayer = Stream.of(playerListA, playerListB)
                .flatMap(players -> players.stream())
                .min((Comparator.comparing(player -> player.getGoals())));
        Optional<Player> bestPlayer = Stream.of(playerListA, playerListB)
                .flatMap(players -> players.stream())
                .max((Comparator.comparing(player -> player.getGoals())));
        LOGGER.log(Level.INFO, "Worst Player: {0}", worstPlayer.get().getLastName());
        LOGGER.log(Level.INFO, "Best Player: {0}", bestPlayer.get().getLastName());
    }

    private static void flatMapExample(List<Player> playerListA, List<Player> playerListB) {
        List<String> flatList = Stream.of(playerListA, playerListB)
                .flatMap(players -> players.stream())
                .map(player -> player.getFirstName().toUpperCase(Locale.ROOT))
                .toList();
        LOGGER.log(Level.INFO, "FlatMap: {0}", flatList.toString());
    }

    private static void mapExample(List<Player> playerList) {
        List<String> uppercaseNames = playerList.stream()
                .map(player -> player.getLastName().toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
        LOGGER.log(Level.INFO, "Uppercase Map: {0}", uppercaseNames);
    }
}
