package me.huynhducphu.section_5;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import me.huynhducphu.section_5.util.JpaUtil;

/**
 * Admin 9/16/2025
 **/

// Biên class này thành entry point
// Khi start phải proj phải chạy vào class này
@WebListener
public class Application implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JpaUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JpaUtil.close();
    }
}
