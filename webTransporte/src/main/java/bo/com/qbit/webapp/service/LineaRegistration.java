package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Dosificacion;
import bo.com.qbit.webapp.model.Linea;
import bo.com.qbit.webapp.model.Pais;

//The @Stateless annotation eliminates the need for manual transaction demarcation

@Stateless
public class LineaRegistration extends DataAccessService<Linea>{
	public LineaRegistration(){
		super(Linea.class);
	}
}
