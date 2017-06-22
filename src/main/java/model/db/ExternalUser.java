package model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalUser {

    private int id;
    private String name;
    private String phoneNumber;
    private Location location;
}
