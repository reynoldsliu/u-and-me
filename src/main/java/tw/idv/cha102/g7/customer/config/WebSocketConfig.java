package tw.idv.cha102.g7.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//@Configuration
public class WebSocketConfig {

//pom.xml:下列的依賴檔會導致衝突websocket，以致無法啟動springboot並導入類別，需再詢問會不會用到下列的依賴:
//   <dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-tomcat</artifactId>
//			<scope>provided</scope>
//	</dependency>

    //    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
