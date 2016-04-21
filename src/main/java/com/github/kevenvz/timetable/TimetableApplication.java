package com.github.kevenvz.timetable;

import com.github.kevenvz.timetable.model.Teacher;
import com.github.kevenvz.timetable.model.TimetableEntry;
import com.github.kevenvz.timetable.service.MigrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class TimetableApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TimetableApplication.class);

    @Inject
    private MigrationService migrationService;

    public static void main(String[] args) {
        SpringApplication.run(TimetableApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        final Future<Map<String, Teacher>> teacherMap = migrationService.migrateTeachers();

        while (!(teacherMap.isDone())) {
            Thread.sleep(10);
        }

        final Future<List<TimetableEntry>> timetableEntries = migrationService.migrateTimetableEntries(teacherMap.get());

        while (!(timetableEntries.isDone())) {
            Thread.sleep(10);
        }

        log.info("Done migrating teachers and timetable");
    }
}
