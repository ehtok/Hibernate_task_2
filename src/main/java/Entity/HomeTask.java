package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOME_TASK")
@PrimaryKeyJoinColumn(name = "task_id")
public class HomeTask extends Task {

    @Column(name = "start_Date")
    private String startDate;

    @Column(name = "end_Date")
    private String endDate;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "p_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "p_surname"))
    })

    private Person performer;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "l_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "l_surname"))
    })

    private Person looking;


}
