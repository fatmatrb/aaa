package com.attijari.stage.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "titre")
@Data
public class Titre {
    @Id
    @Column(name = "idTitre")
    private  Long idTitre ;
    private String numdom;
    private String nattit;
    private String coddevCnt;
    private String coddevRegl;
    private String codreg;
    private String codliv;
    private String coddel;
    private String codregstat;
    private Date datdom;
    private String numcnt;
    private Date datcnt;
    private double mntptfndev;
    private double mntfobdev;
    private String libfrs;
    private String adrfrs;
    private double mntptfntnd;
    private double mntfobtnd;
    private Date datdepaut;
    private Date datfintit;
    private String etattitre;
    private String codugdom;
    private Date datoper;
    private String utilisateur;
    private Double id;
    private String raisoc;
    private String adrclt;
    private String nomclt;
    private String coddou;
    private String anneedom;
    private String numborbct;
    private double mntimptnd;
    private double mntimp;
    private String echeance;
    private Integer valide;
    private String facture;
    private String accordbctregl;
    private String capitale;
    private String policecotinaceregl;
    private String codpayOrg;
    private String codpayAchDestdeb;
    private String codpayProvDestfin;
    private String codbanq;
    private String codugbct;
    private String numcpt;
    private String clebct;
    private String codpayTier;
    private Integer nbrrbq;
    private String codugdombct;
    private String initiateur;
    private String numDossTtn;
    private Integer valideAgc;
    private Long numeroVerou;
    private String phase;
    private String matphase;
    private Date datphase;
    private Date dateCreation;

}
