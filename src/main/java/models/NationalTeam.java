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
public class NationalTeam {

    private Integer id;
    private String name;
    private List<Player> players;

    public NationalTeam(String name) {
        this.name = name;
    }

    public NationalTeam(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

}
