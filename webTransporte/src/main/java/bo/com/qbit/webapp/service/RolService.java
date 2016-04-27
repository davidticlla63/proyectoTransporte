package bo.com.qbit.webapp.service;

import javax.ejb.Stateless;

import bo.com.qbit.webapp.model.Roles;

@Stateless
public class RolService extends DataAccessService<Roles>{
	public RolService(){
		super(Roles.class);
	}
}
