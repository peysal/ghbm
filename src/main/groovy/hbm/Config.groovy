package main.groovy.hbm

import main.java.Book
import org.hibernate.cfg.Configuration
import org.hibernate.service.ServiceRegistryBuilder

/**
 *
 */

class Config {

    def hibProps = [
            "hibernate.dialect": "org.hibernate.dialect.H2Dialect",
            "hibernate.connection.driver_class": "org.h2.Driver",
            "hibernate.connection.url": "jdbc:h2:tcp://localhost/~/development/db/h2/test",
            "hibernate.connection.username": "sa",
            "hibernate.connection.password": "",
            "hibernate.connection.pool_size": "1",
            "hibernate.connection.autocommit": "true",
            "hibernate.cache.provider_class": "org.hibernate.cache.NoCacheProvider",
            "hibernate.show_sql": "true",
            "hibernate.transaction.factory_class": "org.hibernate.transaction.JDBCTransactionFactory",
            "hibernate.current_session_context_class": "thread"
    ]

    def configureHibernate(props) {
        def config = new Configuration()
        props.each { k, v -> config.setProperty(k, v) }

        config.addAnnotatedClass(Book)

        def serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        def sessionFactory = config.buildSessionFactory(serviceRegistry);
        return sessionFactory
    }

    def factory = configureHibernate(hibProps);

}