package wirelessmesh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * This is the RoomAssigned event.
 */
@AllArgsConstructor
@Getter
@Builder
public class RoomAssigned {
    private final String routerId;
    private final String room;
}
