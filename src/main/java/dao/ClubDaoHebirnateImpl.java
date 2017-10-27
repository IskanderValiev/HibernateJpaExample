package dao;

import hebirnate.HibernateConnector;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.Club;
import models.NationalTeam;
import models.Player;
import org.hibernate.Session;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ClubDaoHebirnateImpl {

    private Session session;

    public List<Club> findByName(String name) {
        //opening session
        this.session = HibernateConnector.getConnector().getSession();

        //transaction beginning
        session.beginTransaction();

        List<Club> clubs = session.createQuery("FROM models.Club club where club.name = :clubName", Club.class).setParameter("clubName", name).list();
        session.getTransaction().commit();

        return clubs;
    }

    public Integer savePlayer(Player player) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();

        Integer resultId = (Integer) session.save(player);

        session.getTransaction().commit();

        return resultId;
    }

    public Integer saveClub(Club club) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();

        Integer resultId = (Integer) session.save(club);

        session.getTransaction().commit();
        return resultId;
    }

    public void deleteClub(Club club) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        session.delete(club);
    }

    public void update(Club club) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();
        session.update(club);
    }
}
