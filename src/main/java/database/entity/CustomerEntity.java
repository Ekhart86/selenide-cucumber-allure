package database.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    private String id;
    private String age;
    private String firstName;
    private String lastName;

}
