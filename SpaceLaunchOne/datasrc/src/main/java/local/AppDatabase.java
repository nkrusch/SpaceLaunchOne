package local;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Launch.class, Details.class, Mission.class, RocketFilter.class, AgencyFilter.class, LocationFilter.class,
        FavoriteLaunch.class, Agency.class, Location.class, Pad.class, Rocket.class, LocationAgency.class, AgencyMission.class},
        version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "launchData";
    private static AppDatabase sInstance;

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            database.execSQL("CREATE TABLE `favorites` (`fid` INTEGER NOT NULL, PRIMARY KEY(`fid`))");
            database.execSQL("CREATE TABLE `agencies` (`aid` INTEGER NOT NULL, `name` TEXT, `countryCode` TEXT, `abbrev` TEXT, `islsp` INTEGER NOT NULL, `type` INTEGER NOT NULL, `infoURLs` TEXT, `wikiURL` TEXT, `changed` TEXT, `lastModified` INTEGER, PRIMARY KEY(`aid`))");
            database.execSQL("CREATE TABLE `locations` (`lid` INTEGER NOT NULL, `name` TEXT, `countryCode` TEXT, `infoURLs` TEXT, `lastModified` INTEGER, PRIMARY KEY(`lid`))");
            database.execSQL("CREATE TABLE `pads` (`pid` INTEGER NOT NULL, `name` TEXT, `latitude` REAL, `longitude` REAL, `retired` INTEGER NOT NULL, `locationId` INTEGER NOT NULL, `infoURLs` TEXT, `lastModified` INTEGER, PRIMARY KEY(`pid`))");
            database.execSQL("CREATE TABLE `rockets` (`rid` INTEGER NOT NULL, `name` TEXT, `familyName` TEXT, `configuration` TEXT, `wikiURL` TEXT, `infoURLs` TEXT, `imageURL` TEXT, `lastModified` INTEGER, PRIMARY KEY(`rid`))");
            database.execSQL("CREATE TABLE `locationagency` (`lid` INTEGER NOT NULL, `aid` INTEGER NOT NULL, PRIMARY KEY(`lid`, `aid`))");
            database.execSQL("CREATE TABLE `agencymission`  (`mid` INTEGER NOT NULL, `aid` INTEGER NOT NULL, PRIMARY KEY(`mid`, `aid`))");

            database.execSQL("DROP INDEX `index_details_agencyId_agencyName`");
            database.execSQL("DROP INDEX `index_details_padId_padName`");
            database.execSQL("DROP INDEX `index_details_rocketId_rocketName`");

            database.execSQL("CREATE INDEX `index_agencymission_aid` ON `agencymission` (`aid`)");
            database.execSQL("CREATE INDEX `index_agencymission_mid` ON `agencymission` (`mid`)");
            database.execSQL("CREATE INDEX `index_details_agencyId` ON `details` (`agencyId`)");
            database.execSQL("CREATE INDEX `index_details_locationId` ON `details` (`locationId`)");
            database.execSQL("CREATE INDEX `index_details_padId` ON `details` (`padId`)");
            database.execSQL("CREATE INDEX `index_details_rocketId` ON `details` (`rocketId`)");
            database.execSQL("CREATE INDEX `index_locationagency_aid` ON `locationagency` (`aid`)");
            database.execSQL("CREATE INDEX `index_locationagency_lid` ON `locationagency` (`lid`)");
            database.execSQL("CREATE INDEX `index_pads_locationId` ON `pads` (`locationId`)");
        }
    };

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .addMigrations(MIGRATION_1_2)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract AppDao dao();
}