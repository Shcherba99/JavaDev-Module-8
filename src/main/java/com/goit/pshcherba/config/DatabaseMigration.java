package com.goit.pshcherba.config;

import org.flywaydb.core.Flyway;

public class DatabaseMigration {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./data/megasoft", "sa", "")
                .locations("filesystem:./migration")
                .cleanDisabled(false)
                .load();

        flyway.clean(); //для даного ДЗ, щоб мати можливість очистити БД і запустити міграції заново

        flyway.migrate();
    }
}
