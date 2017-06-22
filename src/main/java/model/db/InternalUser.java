package model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalUser {

    private int id;
    private String name;
    private String department;
    private String job;
    private String phoneNumber;
    private String mailAddress;
    private Location location;
}

