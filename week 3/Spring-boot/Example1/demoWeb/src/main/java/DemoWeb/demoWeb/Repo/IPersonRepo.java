package DemoWeb.demoWeb.Repo;

import DemoWeb.demoWeb.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepo extends JpaRepository<Person, Integer> {


}
