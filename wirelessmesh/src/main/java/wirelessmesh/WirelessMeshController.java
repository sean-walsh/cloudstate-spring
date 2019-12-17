package wirelessmesh;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class WirelessMeshController {

    @RequestMapping(value = "/activate-device", method = POST)
    public ResponseEntity<Object> createProduct(@RequestBody Deviceservice.ActivateDeviceCommand cmd) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        DeviceServiceGrpc.DeviceServiceBlockingStub stub
                = DeviceServiceGrpc.newBlockingStub(channel);

        stub.activate(Deviceservice.ActivateDeviceCommand.newBuilder()
                .setDeviceId(cmd.getDeviceId())
                .setCustomerId(cmd.getCustomerId())
                .build());

        channel.shutdown();

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/assign-room", method = POST)
    public ResponseEntity<Object> createProduct(@RequestBody Deviceservice.AssignRoomCommand cmd) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        DeviceServiceGrpc.DeviceServiceBlockingStub stub
                = DeviceServiceGrpc.newBlockingStub(channel);

        stub.assignRoom(Deviceservice.AssignRoomCommand.newBuilder()
                .setDeviceId(cmd.getDeviceId())
                .setRoom(cmd.getRoom())
                .build());

        channel.shutdown();

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}