package DemoWeb.demoWeb.Repository;

import DemoWeb.demoWeb.DemoWebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("person1")
public class Person1 implements IPersona{
    private static Logger LOG = LoggerFactory.getLogger(DemoWebApplication.class);
    @Override
    public void register(String name) {
        LOG.info("the new register is: "+ name);
    }
}
