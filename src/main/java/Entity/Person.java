package Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Person {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
}
