package com.attijari.stage.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="module")
@Data
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idModule")
    private Long idModule;
    private String libModule;
    private String nameTabModule;
    
    @OneToMany(mappedBy = "module",  cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Attributs> attributs ;
}