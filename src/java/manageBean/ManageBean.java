package manageBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Person;
import session.SessionBean;

@ManagedBean
@SessionScoped
public class ManageBean {
@EJB
    SessionBean sessionBean;//facade

 private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
public String insertIntoDB() {
        Person person = new Person();
        person.setName(this.getName());
        person.setSurname(this.getSurname());
        boolean resutl = sessionBean.insertPerson(person);
        if (resutl) {
            return "success";
        } else {
            return "formjsf";
        }
    }
}
