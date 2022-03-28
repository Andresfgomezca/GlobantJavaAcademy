package DemoWeb.demoWeb.Repository;


import DemoWeb.demoWeb.DemoWebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("person2")
public class Person2 implements IPersona{
    private static Logger LOG = LoggerFactory.getLogger(DemoWebApplication.class);
    @Override
    public void register(String name) {
        LOG.info(name+" was not registered");
    }
}
