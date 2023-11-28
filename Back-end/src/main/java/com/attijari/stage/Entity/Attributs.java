package com.attijari.stage.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="attribut")
@Data
public class Attributs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAttribut")
    private Long idattributs;

    private String libAttributs;
    private String nameAttributs;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idModule")
    private Module module;
}
