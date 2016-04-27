package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.GrupoProducto;
import bo.com.qbit.webapp.model.TipoProducto;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class GrupoProductoRegistration extends DataAccessService<GrupoProducto>{
	public GrupoProductoRegistration(){
		super(GrupoProducto.class);
	}
}
