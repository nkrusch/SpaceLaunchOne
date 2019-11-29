package local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
public interface AppDao {

    @Query("SELECT id, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON id = uid WHERE (launchDateUTC > :cutoff OR status = 5) " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "AND id NOT IN (SELECT id FROM Launch JOIN details ON id = uid " +
            "WHERE status=1 AND launchDateUTC > :cutoff " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC ASC LIMIT 1) " +
            "ORDER BY launchDateUTC ASC LIMIT :limit OFFSET :offset")
    LiveData<List<Launch>> loadLaunches(long cutoff, int limit, int offset);

    @Query("SELECT id, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON id = uid WHERE (launchDateUTC <= :cutoff AND status != 5) " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC DESC LIMIT :limit OFFSET :offset")
    LiveData<List<Launch>> pastLaunches(long cutoff, int limit, int offset);

    @Query("SELECT id, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON id = uid JOIN favorites on id = fid " +
            "ORDER BY launchDateUTC DESC LIMIT :limit OFFSET :offset")
    LiveData<List<Launch>> favoriteLaunches(int limit, int offset);

    @Query("SELECT id, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON id = uid WHERE " +
            "(name LIKE :q OR agencyName LIKE :q OR locationName LIKE :q OR rocketName LIKE :q) " +
            "ORDER BY launchDateUTC DESC LIMIT :limit OFFSET :offset")
    List<Launch> searchLaunches(String q, int limit, int offset);

    @Query("SELECT DISTINCT aid AS agencyId, aid as afid, name as agencyName, countryCode as agencyCountryCode " +
            "FROM agencies WHERE name IS NOT NULL AND name <> 'Unknown' UNION " +
            "SELECT DISTINCT agencyId, agencyId as afid, agencyName, agencyCountryCode " +
            "from details WHERE agencyName IS NOT NULL AND agencyName <> 'Unknown' " +
            "ORDER BY agencyName COLLATE NOCASE ASC LIMIT :limit OFFSET :offset")
    LiveData<List<AgencyLookup>> agencies(int limit, int offset);

    @Query("SELECT DISTINCT lid AS locationId, name as locationName, lid as pfid, countryCode as locationCountryCode " +
            "FROM locations WHERE name IS NOT NULL AND countryCode <> 'UNK' UNION " +
            "SELECT DISTINCT locationId, locationName, locationId as pfid, locationCountryCode " +
            "from launch JOIN details ON id = uid WHERE locationName IS NOT NULL AND locationCountryCode <> 'UNK' " +
            "ORDER BY locationName COLLATE NOCASE ASC LIMIT :limit OFFSET :offset")
    LiveData<List<LocationLookup>> locations(int limit, int offset);

    @Query("SELECT id, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON id = uid WHERE status=1 AND launchDateUTC > :cutoff " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC ASC LIMIT 1")
    LiveData<Launch> getNext(long cutoff);

    @Query("SELECT id, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON id = uid WHERE status=1 AND launchDateUTC > :cutoff " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC ASC LIMIT 1")
    Launch getNextLaunch(long cutoff);

    @Transaction
    @Query("SELECT * from launch JOIN details ON id = uid WHERE id = :id")
    LaunchDetails get(int id);

    @Transaction
    @Query("SELECT * from launch JOIN details ON id = uid WHERE id = :id")
    LiveData<LaunchDetails> getLaunchDetails(int id);

    @Transaction
    @Query("SELECT * from locations WHERE lid = :id")
    LiveData<LocationDetails> getLocationDetails(int id);

    @Query("SELECT lastModified from details WHERE uid = :id")
    Date getLastModified(int id);

    @Query("SELECT launchDateUTC from launch WHERE id = :id")
    Long getLaunchDateUTC(int id);

    @Query("SELECT * from favorites WHERE fid = :id")
    LiveData<FavoriteLaunch> getFavorite(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addFavorite(FavoriteLaunch f);

    @Delete
    void removeFavorite(FavoriteLaunch f);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Launch... launches);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Details... launches);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Agency... agencies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Location... locations);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Pad... pads);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(LocationAgency... lax);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Mission> missions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFullRecord(Launch launch, Details details, List<Mission> missions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFullRecord(Location location, List<Pad> pads);

    @Query("SELECT DISTINCT rocketId, rocketName, rfid from details " +
            "LEFT JOIN rocketFilter ON rfid=rocketId WHERE rocketName IS NOT NULL ORDER BY rocketName")
    LiveData<List<RocketLookup>> getRocketLookup();

    @Query("SELECT DISTINCT agencyId, agencyName, afid, agencyImage, agencyCountryCode from details " +
            "LEFT JOIN agencyFilter ON afid=agencyId WHERE agencyName IS NOT NULL ORDER BY agencyName COLLATE NOCASE ASC")
    LiveData<List<AgencyLookup>> getAgencyLookup();

    @Query("SELECT DISTINCT locationId, locationName, pfid, locationCountryCode FROM details " +
            "JOIN launch ON id = uid LEFT JOIN locationFilter ON pfid=locationId " +
            "WHERE locationName IS NOT NULL ORDER BY locationName")
    LiveData<List<LocationLookup>> getLocationLookup();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addAFilters(RocketFilter... filter);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addAFilters(AgencyFilter... filter);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addAFilters(LocationFilter... filter);

    @Delete
    void deleteFilters(RocketFilter... filter);

    @Delete
    void deleteFilters(AgencyFilter... filter);

    @Delete
    void deleteFilters(LocationFilter... filter);
}

