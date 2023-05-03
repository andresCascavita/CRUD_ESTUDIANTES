/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiantesJEE.session;

import estudiantesJEE.entity.Untitled;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ANDRES CASCAVITA
 */
@Stateless
public class UntitledFacade extends AbstractFacade<Untitled> implements UntitledFacadeLocal {

    @PersistenceContext(unitName = "EstudiantesJEE-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UntitledFacade() {
        super(Untitled.class);
    }
    
}
