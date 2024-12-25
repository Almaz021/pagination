package ru.itis.fisd.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.itis.fisd.repository.DbWork;

@WebListener
public class ContextListener implements ServletContextListener {

    final static Logger logger = LogManager.getLogger(ContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        logger.info("contextInitialized");
        DbWork.getInstance();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DbWork.getInstance().destroy();
    }
}
