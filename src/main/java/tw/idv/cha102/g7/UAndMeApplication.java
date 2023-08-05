package tw.idv.cha102.g7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan({"member.controller.*",
		"member.controller.*"})
public class UAndMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UAndMeApplication.class, args);
	}

}
