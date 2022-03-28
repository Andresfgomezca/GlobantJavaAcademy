package DemoWeb.demoWeb.Service;

import DemoWeb.demoWeb.Repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//These annotations indicate that we are creating beans in the container

@Component
public class PersonService implements IPersonService {
    //annotation qualifier explains what's the implementation that we want from an interface
    @Autowired
    @Qualifier("person1")
    private IPersona repo;
    //no we need to specify with @qualifier the correct instance
    @Override
    public void register(String name) {
        //repo = new Person1(); //this instantiation will be managed by spring with @autowired defined
        repo.register(name);
    }
}
