package me.huynhducphu.midterm4;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import me.huynhducphu.midterm4.util.JpaUtil;

/**
 * Admin 9/25/2025
 **/
@WebListener
public class Application implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JpaUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JpaUtil.destroy();
    }
}
