package wirelessmesh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * This is the RouterActivated event.
 */
@AllArgsConstructor
@Getter
@Builder
public class DeviceActivated {
    private final String routerId;
    private final String customerId;
}
