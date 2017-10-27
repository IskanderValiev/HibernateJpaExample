package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {

    private Integer id;
    private String name;
    private List<Player> players;

    public Club(String name) {
        this.name = name;
    }

    public Club(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

}
