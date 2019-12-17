package wirelessmesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.cloudstate.javasupport.*;

import wirelessmesh.domain.*;

@SpringBootApplication
public class WirelessMeshSpringApplication {
    public static void main(String[] args) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        SpringApplication.run(WirelessMeshSpringApplication.class, args);

        new CloudState()
                .registerEventSourcedEntity(
                        DeviceEntity.class,
                        Deviceservice.getDescriptor().findServiceByName("DeviceService"),
                        wirelessmesh.persistence.Domain.getDescriptor())
                .start()
                .toCompletableFuture()
                .get();
    }
}
