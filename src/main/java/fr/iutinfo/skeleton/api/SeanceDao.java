package fr.iutinfo.skeleton.api;

import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface SeanceDao {

	@SqlQuery("select * from vueseances where codeSeance= :codeSeance")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Seance findByCodeSeance(@Bind("codeSeance") int codeSeance);

	@SqlQuery("select * from vueseances ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Seance> all();


	@SqlUpdate("DELETE FROM seances WHERE codeSeance = :codeSeance")
	@RegisterMapperFactory(BeanMapperFactory.class)
	void deleteSeanceWithId(@Bind("codeSeance") int codeSeance);

	@SqlUpdate("DELETE FROM seances_groupes WHERE codeSeance = :codeSeance")
	@RegisterMapperFactory(BeanMapperFactory.class)
	void deleteSeanceGroupeWithId(@Bind("codeSeance") int codeSeance);



	void close();


	@SqlUpdate("UPDATE seances SET dateSeance=:date,  heureSeance=:heure, dureeSeance=:duree  WHERE codeSeance = :codeSeance")
	void updateHoraires(@Bind("codeSeance") int codeSeance, @BindBean() EventDto eventDto);


	@SqlQuery("SELECT MAX(codeSeance)+1 AS newId FROM seances")
	int lookForNewId();

	void ajouterSeance();

}