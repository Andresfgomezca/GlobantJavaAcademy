package DemoWeb.demoWeb;
//these libraries are for the logger slf4j
import DemoWeb.demoWeb.Service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(DemoWebApplication.class);

	@Autowired
	private IPersonService servic;
	//doesn't need instantiation because spring finds the repository

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this is a method used to print in console
		System.out.println("The app is printing in console");
		LOG.info("this message is print with console");
		LOG.warn("this is a warning with logger");
		//with this implementation of the instance it will be instantiated numerous times depending on the amount of
		//users using the app
		//servic = new PersonService(); //instance replaced by @autowired
		servic.register("Andres");
	}
}
