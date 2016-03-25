package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface GroupeDao {
	
	
	@SqlQuery("select * from ressources_groupes where codeGroupe= :codeGroupe")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Groupe findByCodeGroupe(@Bind("codeGroupe") int codeGroupe);
	
	@SqlQuery("select * from ressources_groupes order by nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Groupe> all();


	void close();

}