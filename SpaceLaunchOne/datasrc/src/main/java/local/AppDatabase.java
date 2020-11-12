package local;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Launch.class, Details.class, Mission.class, RocketFilter.class, AgencyFilter.class, LocationFilter.class,
        FavoriteLaunch.class, Agency.class, Location.class, Pad.class, Rocket.class, LocationAgency.class, AgencyMission.class},
        version = 3, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "launchData";
    private static AppDatabase sInstance;

    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            database.execSQL("DROP TABLE `details`");
            database.execSQL("CREATE TABLE `details` (`UUID` TEXT NOT NULL, `net` TEXT, `hashtag` TEXT, `changed` TEXT, `vidURLs` TEXT, `infoURLs` TEXT, `lastModified` INTEGER, `agencyId` INTEGER NOT NULL, `locationId` INTEGER NOT NULL, `padId` INTEGER NOT NULL, `rocketId` INTEGER NOT NULL, PRIMARY KEY(`UUID`))");

            database.execSQL("DROP TABLE `launch`");
            database.execSQL("CREATE TABLE `launch` (`luuid` TEXT NOT NULL, `name` TEXT, `image` TEXT, `launchDateUTC` INTEGER, `locationName` TEXT, `status` INTEGER NOT NULL, PRIMARY KEY(`luuid`))");

            database.execSQL("DROP TABLE `mission`");
            database.execSQL("CREATE TABLE `mission` (`mid` INTEGER NOT NULL, `launchId` TEXT, `name` TEXT, `description` TEXT, `category` TEXT, `wikiURL` TEXT, PRIMARY KEY(`mid`))");

            dropIndexes(database);

            database.execSQL("CREATE INDEX `index_agencymission_aid` ON `agencymission` (`aid`)");          // 1
            database.execSQL("CREATE INDEX `index_agencymission_mid` ON `agencymission` (`mid`)");          // 2
            database.execSQL("CREATE INDEX `index_details_agencyId` ON `details` (`agencyId`)");            // 3
            database.execSQL("CREATE INDEX `index_details_locationId` ON `details` (`locationId`)");        // 4
            database.execSQL("CREATE INDEX `index_details_padId` ON `details` (`padId`)");                  // 5
            database.execSQL("CREATE INDEX `index_details_rocketId` ON `details` (`rocketId`)");            // 6
            database.execSQL("CREATE INDEX `index_launch_launchDateUTC` ON `launch` (`launchDateUTC`)");    // 7
            database.execSQL("CREATE INDEX `index_locationagency_aid` ON `locationagency` (`aid`)");        // 8
            database.execSQL("CREATE INDEX `index_locationagency_lid` ON `locationagency` (`lid`)");        // 9
            database.execSQL("CREATE INDEX `index_mission_launchId` ON `mission` (`launchId`)");            // 10
            database.execSQL("CREATE INDEX `index_pads_locationId` ON `pads` (`locationId`)");              // 11
        }
    };

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            String columns = "`uid`, `net`, `hashtag`, `changed`, `vidURLs`, `infoURLs`, `lastModified`, `agencyId`, `locationId`, `padId`, `rocketId`";

            database.execSQL("ALTER TABLE `details` RENAME TO `details_old`;");
            database.execSQL("CREATE TABLE `details` (`uid` INTEGER NOT NULL, `net` TEXT, `hashtag` TEXT, `changed` TEXT, `vidURLs` TEXT, `infoURLs` TEXT, `lastModified` INTEGER, `agencyId` INTEGER NOT NULL, `locationId` INTEGER NOT NULL, `padId` INTEGER NOT NULL, `rocketId` INTEGER NOT NULL, PRIMARY KEY(`uid`))");
            database.execSQL("INSERT INTO `details` (" + columns + ") SELECT " + columns + " FROM `details_old`");
            database.execSQL("DROP TABLE `details_old`");

            database.execSQL("CREATE TABLE `favorites` (`fid` INTEGER NOT NULL, PRIMARY KEY(`fid`))");
            database.execSQL("CREATE TABLE `agencies` (`aid` INTEGER NOT NULL, `name` TEXT, `countryCode` TEXT, `abbrev` TEXT, `islsp` INTEGER NOT NULL, `type` INTEGER NOT NULL, `infoURLs` TEXT, `wikiURL` TEXT, `changed` TEXT, `lastModified` INTEGER, PRIMARY KEY(`aid`))");
            database.execSQL("CREATE TABLE `locations` (`lid` INTEGER NOT NULL, `name` TEXT, `countryCode` TEXT, `infoURLs` TEXT, `lastModified` INTEGER, PRIMARY KEY(`lid`))");
            database.execSQL("CREATE TABLE `pads` (`pid` INTEGER NOT NULL, `name` TEXT, `latitude` REAL, `longitude` REAL, `retired` INTEGER NOT NULL, `locationId` INTEGER NOT NULL, `infoURLs` TEXT, `lastModified` INTEGER, PRIMARY KEY(`pid`))");
            database.execSQL("CREATE TABLE `rockets` (`rid` INTEGER NOT NULL, `name` TEXT, `familyName` TEXT, `configuration` TEXT, `wikiURL` TEXT, `infoURLs` TEXT, `imageURL` TEXT, `lastModified` INTEGER, PRIMARY KEY(`rid`))");
            database.execSQL("CREATE TABLE `locationagency` (`lid` INTEGER NOT NULL, `aid` INTEGER NOT NULL, PRIMARY KEY(`lid`, `aid`))");
            database.execSQL("CREATE TABLE `agencymission`  (`mid` INTEGER NOT NULL, `aid` INTEGER NOT NULL, PRIMARY KEY(`mid`, `aid`))");

            dropIndexes(database);

            database.execSQL("CREATE INDEX `index_agencymission_aid` ON `agencymission` (`aid`)");          // 1
            database.execSQL("CREATE INDEX `index_agencymission_mid` ON `agencymission` (`mid`)");          // 2
            database.execSQL("CREATE INDEX `index_details_agencyId` ON `details` (`agencyId`)");            // 3
            database.execSQL("CREATE INDEX `index_details_locationId` ON `details` (`locationId`)");        // 4
            database.execSQL("CREATE INDEX `index_details_padId` ON `details` (`padId`)");                  // 5
            database.execSQL("CREATE INDEX `index_details_rocketId` ON `details` (`rocketId`)");            // 6
            database.execSQL("CREATE INDEX `index_launch_launchDateUTC` ON `launch` (`launchDateUTC`)");    // 7
            database.execSQL("CREATE INDEX `index_locationagency_aid` ON `locationagency` (`aid`)");        // 8
            database.execSQL("CREATE INDEX `index_locationagency_lid` ON `locationagency` (`lid`)");        // 9
            database.execSQL("CREATE INDEX `index_mission_launchId` ON `mission` (`launchId`)");            // 10
            database.execSQL("CREATE INDEX `index_pads_locationId` ON `pads` (`locationId`)");              // 11
        }
    };

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract AppDao dao();

    private static void dropIndexes(SupportSQLiteDatabase db) {

        try {
            Cursor cursor = db.query("SELECT name FROM sqlite_master WHERE type == 'index'", null);
            int numIndexes = (cursor == null) ? 0 : cursor.getCount();
            Log.d(LOG_TAG, "Num indexes to drop: " + numIndexes);
            if (numIndexes > 0) {
                String[] indexNames = new String[numIndexes];
                int i = 0;
                while (cursor.moveToNext()) {
                    indexNames[i++] = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                }

                for (i = 0; i < indexNames.length; i++) {
                    Log.d(LOG_TAG, "Dropping index: " + indexNames[i] + "...");
                    try {
                        db.execSQL("DROP INDEX " + indexNames[i]);
                        Log.e(LOG_TAG, "...index dropped!");
                    } catch (Exception e) {
                        Log.e(LOG_TAG, "Error dropping index", e);
                    }
                }
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error dropping index", e);
        }
    }
}