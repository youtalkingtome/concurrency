import model.Persons;

import java.util.List;

public class NullNightMare {

    public void processData(List<Persons> persons) {
        if (null != persons && persons.size() > 0) {
            for (Persons person : persons) {
                if (null != person.getEmail()  && null != person.getLastName())
                {

                }
            }
        }
    }

    public static void main(String[] args) {


    }
}
