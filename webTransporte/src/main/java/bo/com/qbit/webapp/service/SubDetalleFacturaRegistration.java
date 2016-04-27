package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.DetalleFactura;
import bo.com.qbit.webapp.model.Dosificacion;
import bo.com.qbit.webapp.model.Pais;
import bo.com.qbit.webapp.model.Producto;
import bo.com.qbit.webapp.model.SubDetalleFactura;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class SubDetalleFacturaRegistration extends DataAccessService<SubDetalleFactura>{
	public SubDetalleFacturaRegistration(){
		super(SubDetalleFactura.class);
	}
}
