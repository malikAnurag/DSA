package com.okta.javakafka.dao;

import com.okta.javakafka.entity.Developer;
import com.okta.javakafka.entity.Team;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pagerDao")
public class PagerDaoImpl implements PagerDao {

    @Override
    public boolean createTeam(Team team, List<Developer> developers) {
            Configuration cf = new Configuration();
            cf.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = cf.buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            team.setDeveloperList(developers);
            session.save(team);
            session.getTransaction().commit();
            session.close();
            return true;
    }

    @Override
    public Developer getDeveloperFromTeamId(int teamId) {
        Configuration cf = new Configuration();
        cf.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Developer.class);
        criteria.add(Restrictions.eq("team_id", teamId));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (Developer) criteria.uniqueResult();
    }


}
