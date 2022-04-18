package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WORK_TASK")
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask extends Task {

    @Column(name = "cost")
    private Double cost;
}
