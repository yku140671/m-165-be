package org.example.m165backend.Bands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BandsServiceImpl implements BandsService {

    @Autowired
    private BandsRepository bandsRepository;

    @Override
    public List<Bands> getAllBands() {
        return bandsRepository.findAll();
    }

    @Override
    public Bands getBandById(String id) {
        Optional<Bands> band = bandsRepository.findById(id);
        return band.orElse(null);
    }

    @Override
    public Bands createBand(Bands band) {
        return bandsRepository.save(band);
    }

    @Override
    public Bands updateBand(String id, Bands band) {
        Bands existingBand = getBandById(id);
        if (existingBand != null) {
            existingBand.setName(band.getName());
            existingBand.setGenre(band.getGenre());
            // Setze weitere Attribute entsprechend
            return bandsRepository.save(existingBand);
        }
        return null;
    }

    @Override
    public void deleteBand(String id) {
        bandsRepository.deleteById(id);
    }
}