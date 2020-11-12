package local;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface AppDao {

    @Query("SELECT  luuid, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON  luuid = UUID WHERE (launchDateUTC > :cutoff OR status = 5) " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "AND  luuid NOT IN (SELECT  luuid FROM Launch JOIN details ON  luuid = UUID " +
            "WHERE status=1 AND launchDateUTC > :cutoff " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC ASC LIMIT 1) " +
            "ORDER BY launchDateUTC ASC LIMIT :limit OFFSET :offset")
    LiveData<List<Launch>> loadLaunches(long cutoff, int limit, int offset);

    @Query("SELECT  luuid, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON  luuid = UUID WHERE (launchDateUTC <= :cutoff AND status != 5) " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC DESC LIMIT :limit OFFSET :offset")
    LiveData<List<Launch>> pastLaunches(long cutoff, int limit, int offset);

    @Query("SELECT luuid, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON luuid = UUID JOIN favorites F on luuid = F.fid " +
            "ORDER BY launchDateUTC DESC LIMIT :limit OFFSET :offset")
    LiveData<List<Launch>> favoriteLaunches(int limit, int offset);

    @Query("SELECT luuid, L.name as name, image, launchDateUTC, locationName, status " +
            "FROM launch AS L JOIN details ON  luuid = UUID " +
            "JOIN agencies AS A on agencyId = aid " +
            "JOIN locations as O on locationId=lid WHERE " +
            "(L.name LIKE :q OR A.name LIKE :q OR O.name LIKE :q) " +
            "ORDER BY launchDateUTC DESC LIMIT :limit OFFSET :offset")
    List<Launch> searchLaunches(String q, int limit, int offset);

    @Query("SELECT  luuid, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON  luuid = UUID WHERE status=1 AND launchDateUTC > :cutoff " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC ASC LIMIT 1")
    LiveData<Launch> getNext(long cutoff);

    @Query("SELECT  luuid, name, image, launchDateUTC, locationName, status " +
            "FROM Launch JOIN details ON  luuid = UUID WHERE status=1 AND launchDateUTC > :cutoff " +
            "AND rocketId NOT IN (SELECT rfid FROM rocketFilter) " +
            "AND agencyId NOT IN (SELECT afid FROM agencyFilter) " +
            "AND locationId NOT IN (SELECT pfid FROM locationFilter) " +
            "ORDER BY launchDateUTC ASC LIMIT 1")
    Launch getNextLaunch(long cutoff);

    @Query("SELECT * FROM agencies ORDER BY name COLLATE NOCASE ASC LIMIT :limit OFFSET :offset")
    LiveData<List<Agency>> agencies(int limit, int offset);

    @Query("SELECT * FROM locations WHERE countryCode <> 'UNK' ORDER BY name COLLATE NOCASE ASC LIMIT :limit OFFSET :offset")
    LiveData<List<Location>> locations(int limit, int offset);

    @Transaction
    @Query("SELECT * from launch JOIN details ON  luuid = UUID WHERE  luuid = :id")
    LaunchDetails get(String id);

    @Transaction
    @Query("SELECT * from launch JOIN details ON  luuid = UUID WHERE  luuid = :id")
    LiveData<LaunchDetails> getLaunchDetails(String id);

    @Transaction
    @Query("SELECT * from locations WHERE lid = :id")
    LiveData<LocationDetails> getLocationDetails(int id);

    @Transaction
    @Query("SELECT * from agencies WHERE aid = :id")
    LiveData<AgencyDetails> getAgencyDetails(int id);

    @Query("SELECT launchDateUTC from launch WHERE  luuid = :id")
    Long getLaunchDateUTC(String id);

    @Query("SELECT F.fid from favorites F JOIN details on F.fid=UUID " +
            "WHERE F.fid = :id")
    LiveData<FavoriteLaunch> getFavorite(String id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addFavorite(FavoriteLaunch f);

    @Delete
    void removeFavorite(FavoriteLaunch f);

    @Transaction
    @Query("UPDATE launch set image = :image where  luuid = :id")
    void updateImage(String id, String image);

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
    void insertAll(Rocket... rockets);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(LocationAgency... lax);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(AgencyMission... amx);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Mission... missions);

    @Query("SELECT DISTINCT rid as rocketId, name as rocketName, rfid from rockets " +
            "LEFT JOIN rocketFilter ON rfid=rid WHERE name IS NOT NULL ORDER BY name COLLATE NOCASE ASC")
    LiveData<List<RocketLookup>> getRocketLookup();

    @Query("SELECT DISTINCT aid AS agencyId, name AS agencyName, afid from agencies " +
            "LEFT JOIN agencyFilter ON afid=aid WHERE name IS NOT NULL ORDER BY name COLLATE NOCASE ASC")
    LiveData<List<AgencyLookup>> getAgencyLookup();

    @Query("SELECT DISTINCT lid as locationId, name as locationName, pfid FROM locations " +
            "LEFT JOIN locationFilter ON pfid=lid " +
            "WHERE name IS NOT NULL ORDER BY name")
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

