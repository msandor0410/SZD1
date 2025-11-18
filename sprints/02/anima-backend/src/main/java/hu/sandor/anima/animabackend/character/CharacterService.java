package hu.sandor.anima.animabackend.character;

import hu.sandor.anima.animabackend.character.dto.CharacterRequest;
import hu.sandor.anima.animabackend.user.User;
import hu.sandor.anima.animabackend.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository repo;
    private final UserRepository users;

    public CharacterService(CharacterRepository repo, UserRepository users) {
        this.repo = repo;
        this.users = users;
    }

    public Character create(Long userId, CharacterRequest req) {
        User creator = users.findById(userId).orElseThrow();

        Character c = new Character();
        c.setCreator(creator);

        c.setName(req.name);
        c.setClassName(req.className);
        c.setLevel(req.level);
        c.setRace(req.race);
        c.setGender(req.gender);
        c.setAppearance(req.appearance);
        c.setHeightCm(req.heightCm);
        c.setWeightKg(req.weightKg);
        c.setBackground(req.background);

        c.setStrScore(req.strScore);
        c.setAgiScore(req.agiScore);
        c.setDexScore(req.dexScore);
        c.setConScore(req.conScore);
        c.setIntScore(req.intScore);
        c.setPerScore(req.perScore);
        c.setPowScore(req.powScore);
        c.setWpScore(req.wpScore);

        // Derived stat példák
        c.setLifePoints(req.conScore != null ? req.conScore * 10 : 0);
        c.setAttackBase((req.strScore != null ? req.strScore : 0)
                + (req.dexScore != null ? req.dexScore : 0));
        c.setDefenseBase((req.agiScore != null ? req.agiScore : 0)
                + (req.dexScore != null ? req.dexScore : 0));
        c.setInitiative((req.agiScore != null ? req.agiScore : 0)
                + (req.intScore != null ? req.intScore : 0));

        return repo.save(c);
    }

    public List<Character> getAllByUser(Long userId) {
        return repo.findByCreator_Id(userId);
    }

    public Character getOne(Long id, Long userId) {
        Character c = repo.findById(id).orElseThrow();
        if (!c.getCreator().getId().equals(userId)) {
            throw new RuntimeException("Forbidden");
        }
        return c;
    }

    public Character update(Long id, Long userId, CharacterRequest req) {
        Character c = getOne(id, userId);

        c.setName(req.name);
        c.setClassName(req.className);
        c.setLevel(req.level);
        c.setRace(req.race);
        c.setGender(req.gender);
        c.setAppearance(req.appearance);

        c.setStrScore(req.strScore);
        c.setAgiScore(req.agiScore);
        c.setDexScore(req.dexScore);
        c.setConScore(req.conScore);
        c.setIntScore(req.intScore);
        c.setPerScore(req.perScore);
        c.setPowScore(req.powScore);
        c.setWpScore(req.wpScore);

        c.setLifePoints(req.conScore != null ? req.conScore * 10 : 0);
        c.setAttackBase((req.strScore != null ? req.strScore : 0)
                + (req.dexScore != null ? req.dexScore : 0));
        c.setDefenseBase((req.agiScore != null ? req.agiScore : 0)
                + (req.dexScore != null ? req.dexScore : 0));

        return repo.save(c);
    }

    public void delete(Long id, Long userId) {
        Character c = getOne(id, userId);
        repo.delete(c);
    }
}
