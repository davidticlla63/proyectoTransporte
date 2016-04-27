package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Cliente;
import bo.com.qbit.webapp.model.NitCliente;

//The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class NitClienteRegistration extends DataAccessService<NitCliente>{
	public NitClienteRegistration(){
		super(NitCliente.class);
	}

}

