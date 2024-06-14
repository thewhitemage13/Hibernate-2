package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "profile", schema = "hibernate")
public class Profile{
    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    private String street;
    private String language;

    public void setUser(User user){
        this.user = user;
        user.setProfile(this);
        id = user.getId();
    }
}