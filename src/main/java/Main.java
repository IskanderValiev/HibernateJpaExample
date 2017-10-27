import dao.ClubDaoHebirnateImpl;
import models.Club;
import models.NationalTeam;
import models.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{

        ClubDaoHebirnateImpl clubDaoHebirnate = new ClubDaoHebirnateImpl();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println(clubDaoHebirnate.findByName(reader.readLine()).toString());


        List<Club> club = clubDaoHebirnate.findByName("Rubin");

        NationalTeam nationalTeam = new NationalTeam("Russia");

        Club rubin = club.get(0);


        Player player = new Player("Maxim", "Kannunikov", new NationalTeam("Russia"), rubin);


        System.out.println(clubDaoHebirnate.savePlayer(player));
//        System.out.println(clubDaoHebirnate.saveClub(club));

    }
}
