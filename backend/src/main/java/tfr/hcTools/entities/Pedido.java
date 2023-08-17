package tfr.hcTools.entities;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tb_pedido")
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date ocorrencyDay;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date inquiryDay;
	
	@ManyToOne
	@JoinColumn(name="operador_id")
	private Operador operador;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Pedido() {}

	public Pedido(Long id, Date instante, Date ocorrencyDay, Date inquiryDay, Operador operador, Cliente cliente) {
		super();
		this.id = id;
		this.instante = instante;
		this.ocorrencyDay = ocorrencyDay;
		this.inquiryDay = inquiryDay;
		this.operador = operador;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Date getOcorrencyDay() {
		return ocorrencyDay;
	}

	public void setOcorrencyDay(Date ocorrencyDay) {
		this.ocorrencyDay = ocorrencyDay;
	}

	public Date getInquiryDay() {
		return inquiryDay;
	}

	public void setInquiryDay(Date inquiryDay) {
		this.inquiryDay = inquiryDay;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
