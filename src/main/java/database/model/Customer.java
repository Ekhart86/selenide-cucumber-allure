package database.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String age;
    private String firstName;
    private String lastName;

}
