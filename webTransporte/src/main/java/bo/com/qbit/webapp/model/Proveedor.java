package bo.com.qbit.webapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * Class Proveedor
 * @author David.Ticlla.Felipe
 * @version v1.0
 * 
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "proveedor", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {"nombre","id_empresa"}))
public class Proveedor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String codigo;
	
	private String nombre;
	
	@Column(name="descripcion",nullable=true )
	private String descripcion;
	
	
	@Column(name="telefono",nullable=true )
	private String telefono;
	
	private String direccion;
	
	private String nit;	
	
	@Column(name="margen_utilidad",nullable=true )
	private double margenUtilidad=0;

	@Column(name="numero_autorizacion",nullable=true )
	private String numeroAutorizacion;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_plan_cuenta", nullable=true)
	private PlanCuenta planCuenta;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_plan_cuenta_anticipo", nullable=true)
	private PlanCuenta planCuentaAnticipo;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_ciudad", nullable=true)
	private Ciudad ciudad;
	
	@Size(max = 2) //AC , IN
	private String estado;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name="id_empresa", nullable=false)
	private Empresa empresa;
	
	@Column(name="fecha_registro",nullable=false )
	private Date fechaRegistro;
	
	@Column(name="Usuario_registro",nullable=false )
	private String UsuarioRegistro;

	public Proveedor() {
		super();
		this.id = 0;
		this.estado = "AC";
		this.nombre = "";
		this.descripcion = "";
		this.ciudad= new Ciudad();
	}
	
	@Override
	public String toString() {
		return nombre ;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}else{
			if(!(obj instanceof Proveedor)){
				return false;
			}else{
				if(((Proveedor)obj).id==this.id){
					return true;
				}else{
					return false;
				}
			}
		}
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistro() {
		return UsuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		UsuarioRegistro = usuarioRegistro;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public PlanCuenta getPlanCuenta() {
		return planCuenta;
	}

	public void setPlanCuenta(PlanCuenta planCuenta) {
		this.planCuenta = planCuenta;
	}

	public PlanCuenta getPlanCuentaAnticipo() {
		return planCuentaAnticipo;
	}

	public void setPlanCuentaAnticipo(PlanCuenta planCuentaAnticipo) {
		this.planCuentaAnticipo = planCuentaAnticipo;
	}	
	
	public double getMargenUtilidad() {
		return margenUtilidad;
	}

	public void setMargenUtilidad(double margenUtilidad) {
		this.margenUtilidad = margenUtilidad;
	}

}


