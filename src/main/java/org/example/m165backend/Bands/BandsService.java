package org.example.m165backend.Bands;

import java.util.List;

public interface BandsService {
    List<Bands> getAllBands();
    Bands getBandById(String id);
    Bands createBand(Bands band);
    Bands updateBand(String id, Bands band);
    void deleteBand(String id);
}
