/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiantesJEE.session;

import estudiantesJEE.entity.Untitled;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ANDRES CASCAVITA
 */
@Local
public interface UntitledFacadeLocal {

    void create(Untitled untitled);

    void edit(Untitled untitled);

    void remove(Untitled untitled);

    Untitled find(Object id);

    List<Untitled> findAll();

    List<Untitled> findRange(int[] range);

    int count();
    
}
