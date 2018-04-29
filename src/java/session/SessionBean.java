package session;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import model.Person;

@Stateless
public class SessionBean {
 @PersistenceContext
    private EntityManager em;
 
  public List<Person> getAllTypes() {
        List<Person> result = em
                .createNamedQuery("Person.findAll", Person.class)
                .getResultList();
        return result;
    }
   public boolean insertPerson(Person person) {
        try {
            this.em.persist(person);
            this.em.flush();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
 
}
