
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54)); //2
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56)); //3
            players.add(new Player("Gretzky", "EDM", 35, 89)); //1
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchPlayerByName() {
        assertEquals(null, stats.search("No one"));
        assertEquals("Semenko", stats.search("Semenko").getName());
    }
    
    @Test
    public void playersOfTeam() {
        List<Player> players = stats.team("PIT");
        assertEquals("Lemieux", players.get(0).getName());
    }
    
    @Test
    public void topScorers() {
        List<Player> players = stats.topScorers(2);
        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
    }
}
