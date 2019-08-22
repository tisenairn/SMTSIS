package br.gov.rn.saogoncalo.smtsis.models.formulario;

import br.gov.rn.saogoncalo.smtsis.models.administrative.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "bic_audited")
public class BICAudited {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bicaudited")
    private Long id;

    //    @Column(unique = true, columnDefinition = "int(7) ZEROFILL", length = 7)
    private int usuarioMatricula;

    private String numeroProtocolo;

    @NotNull
    private String observacoes;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_bicaudited_bic", referencedColumnName = "id_BIC", updatable = false)
    private BoletimIncricaoCadastral boletim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUsuarioMatricula() {
        return usuarioMatricula;
    }

    public void setUsuarioMatricula(int usuarioMatricula) {
        this.usuarioMatricula = usuarioMatricula;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public BoletimIncricaoCadastral getBoletim() {
        return boletim;
    }

    public void setBoletim(BoletimIncricaoCadastral boletim) {
        this.boletim = boletim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BICAudited that = (BICAudited) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
