import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void ShouldFindOneTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(4, 100, "MOS", "SPB", 40);
        Ticket ticket2 = new Ticket(3, 200, "JHB", "RHG", 40);
        Ticket ticket3 = new Ticket(2, 300, "MOS", "SPB", 40);
        Ticket ticket4 = new Ticket(1, 400, "<LPG", "NBH", 40);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);

        Ticket[] actual = manager.searchBy("MOS", "SPB");
        Ticket[] expected = { ticket1 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindSeveralTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(4, 400, "MOS", "SPB", 40);
        Ticket ticket2 = new Ticket(3, 300, "JHB", "RHG", 40);
        Ticket ticket3 = new Ticket(2, 200, "MOS", "SPB", 40);
        Ticket ticket4 = new Ticket(1, 100, "<LPG", "NBH", 40);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);

        Ticket[] actual = manager.searchBy("MOS", "SPB");
        Ticket[] expected = { ticket1, ticket3 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortMatchingTickets() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket(4, 100, "MOS", "SPB", 40);
        Ticket ticket2 = new Ticket(3, 200, "JHB", "RHG", 40);
        Ticket ticket3 = new Ticket(2, 300, "MOS", "SPB", 40);
        Ticket ticket4 = new Ticket(1, 200, "<MOS", "SPB", 40);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);

        Ticket[] actual = manager.searchBy("MOS", "SPB");
        Ticket[] expected = { ticket1, ticket4, ticket3 };

        Assertions.assertArrayEquals(expected, actual);
    }
}
