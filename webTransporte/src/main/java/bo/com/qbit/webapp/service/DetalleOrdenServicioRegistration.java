package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.DetalleOrdenServicio;
import bo.com.qbit.webapp.model.Dosificacion;
import bo.com.qbit.webapp.model.Pais;
import bo.com.qbit.webapp.model.Producto;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class DetalleOrdenServicioRegistration extends DataAccessService<DetalleOrdenServicio>{
	public DetalleOrdenServicioRegistration(){
		super(DetalleOrdenServicio.class);
	}
}
