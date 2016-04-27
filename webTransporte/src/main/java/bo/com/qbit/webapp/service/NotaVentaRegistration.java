package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.DetalleNotaVenta;
import bo.com.qbit.webapp.model.NotaVenta;
import bo.com.qbit.webapp.model.OrdenVenta;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class NotaVentaRegistration extends DataAccessService<NotaVenta>{
	public NotaVentaRegistration(){
		super(NotaVenta.class);
	}
}
