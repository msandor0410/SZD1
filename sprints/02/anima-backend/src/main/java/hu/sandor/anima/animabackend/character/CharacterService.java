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

    // =====================================================
    // CREATE CHARACTER
    // =====================================================
    public Character create(Long userId, CharacterRequest req) {

        User creator = users.findById(userId).orElseThrow();

        Character c = new Character();
        c.setCreator(creator);

        // Basic info
        c.setName(req.name);
        c.setClassName(req.className);
        c.setLevel(req.level);
        c.setRace(req.race);
        c.setGender(req.gender);
        c.setAppearance(req.appearance);
        c.setSize(req.size);
        c.setHeightCm(req.heightCm);
        c.setWeightKg(req.weightKg);
        c.setBackground(req.background);

        // Development points
        c.setDevelopmentPoints(req.developmentPoints);

        // Primary stats
        c.setStrScore(req.strScore);
        c.setAgiScore(req.agiScore);
        c.setDexScore(req.dexScore);
        c.setConScore(req.conScore);
        c.setIntScore(req.intScore);
        c.setPerScore(req.perScore);
        c.setPowScore(req.powScore);
        c.setWpScore(req.wpScore);

        // Derived stats
        c.setLifePoints(req.lifePoints);
        c.setLifePointMultiple(req.lifePointMultiple);
        c.setInitiative(req.initiative);
        c.setFatigue(req.fatigue);
        c.setAttackBase(req.attackBase);
        c.setDefenseBase(req.defenseBase);
        c.setMovement(req.movement);

        // Athletics
        c.setAthletics(req.athletics);
        c.setAcrobatics(req.acrobatics);
        c.setAthleticism(req.athleticism);
        c.setClimb(req.climb);
        c.setJump(req.jump);
        c.setRide(req.ride);
        c.setSwim(req.swim);

        // Vigor
        c.setVigor(req.vigor);
        c.setComposure(req.composure);
        c.setFeatsOfStrength(req.featsOfStrength);
        c.setWithstandPain(req.withstandPain);

        // Perception
        c.setPerception(req.perception);
        c.setNotice(req.notice);
        c.setSearchSkill(req.searchSkill);
        c.setTrack(req.track);

        // Intellectual
        c.setIntellectual(req.intellectual);
        c.setAnimals(req.animals);
        c.setAppraisal(req.appraisal);
        c.setMemorize(req.memorize);
        c.setHerbalLore(req.herbalLore);
        c.setHistorySkill(req.historySkill);
        c.setMagicAppraisal(req.magicAppraisal);
        c.setMedicine(req.medicine);
        c.setNavigation(req.navigation);
        c.setOccult(req.occult);
        c.setSciences(req.sciences);

        // Social
        c.setSocial(req.social);
        c.setIntimidate(req.intimidate);
        c.setLeadership(req.leadership);
        c.setPersuasion(req.persuasion);
        c.setStyle(req.style);

        // Subterfuge
        c.setSubterfuge(req.subterfuge);
        c.setDisguise(req.disguise);
        c.setHideSkill(req.hideSkill);
        c.setLockPicking(req.lockPicking);
        c.setPoisons(req.poisons);
        c.setTheft(req.theft);
        c.setStealth(req.stealth);
        c.setTrapLore(req.trapLore);

        // Creative
        c.setCreative(req.creative);
        c.setArt(req.art);
        c.setDance(req.dance);
        c.setForging(req.forging);
        c.setMusic(req.music);
        c.setSleightOfHand(req.sleightOfHand);

        return repo.save(c);
    }

    // =====================================================
    // GET ALL FOR USER
    // =====================================================
    public List<Character> getAllByUser(Long userId) {
        return repo.findByCreator_Id(userId);
    }

    // =====================================================
    // GET ONE BY ID
    // =====================================================
    public Character getOne(Long id, Long userId) {
        Character c = repo.findById(id).orElseThrow();
        if (!c.getCreator().getId().equals(userId)) {
            throw new RuntimeException("Forbidden");
        }
        return c;
    }

    // =====================================================
    // UPDATE CHARACTER
    // =====================================================
    public Character update(Long id, Long userId, CharacterRequest req) {

        Character c = getOne(id, userId);

        // Basic info
        c.setName(req.name);
        c.setClassName(req.className);
        c.setLevel(req.level);
        c.setRace(req.race);
        c.setGender(req.gender);
        c.setAppearance(req.appearance);
        c.setSize(req.size);
        c.setHeightCm(req.heightCm);
        c.setWeightKg(req.weightKg);
        c.setBackground(req.background);

        // Development points
        c.setDevelopmentPoints(req.developmentPoints);

        // Primary
        c.setStrScore(req.strScore);
        c.setAgiScore(req.agiScore);
        c.setDexScore(req.dexScore);
        c.setConScore(req.conScore);
        c.setIntScore(req.intScore);
        c.setPerScore(req.perScore);
        c.setPowScore(req.powScore);
        c.setWpScore(req.wpScore);

        // Derived
        c.setLifePoints(req.lifePoints);
        c.setLifePointMultiple(req.lifePointMultiple);
        c.setInitiative(req.initiative);
        c.setFatigue(req.fatigue);
        c.setAttackBase(req.attackBase);
        c.setDefenseBase(req.defenseBase);
        c.setMovement(req.movement);

        // Athletics
        c.setAthletics(req.athletics);
        c.setAcrobatics(req.acrobatics);
        c.setAthleticism(req.athleticism);
        c.setClimb(req.climb);
        c.setJump(req.jump);
        c.setRide(req.ride);
        c.setSwim(req.swim);

        // Vigor
        c.setVigor(req.vigor);
        c.setComposure(req.composure);
        c.setFeatsOfStrength(req.featsOfStrength);
        c.setWithstandPain(req.withstandPain);

        // Perception
        c.setPerception(req.perception);
        c.setNotice(req.notice);
        c.setSearchSkill(req.searchSkill);
        c.setTrack(req.track);

        // Intellectual
        c.setIntellectual(req.intellectual);
        c.setAnimals(req.animals);
        c.setAppraisal(req.appraisal);
        c.setMemorize(req.memorize);
        c.setHerbalLore(req.herbalLore);
        c.setHistorySkill(req.historySkill);
        c.setMagicAppraisal(req.magicAppraisal);
        c.setMedicine(req.medicine);
        c.setNavigation(req.navigation);
        c.setOccult(req.occult);
        c.setSciences(req.sciences);

        // Social
        c.setSocial(req.social);
        c.setIntimidate(req.intimidate);
        c.setLeadership(req.leadership);
        c.setPersuasion(req.persuasion);
        c.setStyle(req.style);

        // Subterfuge
        c.setSubterfuge(req.subterfuge);
        c.setDisguise(req.disguise);
        c.setHideSkill(req.hideSkill);
        c.setLockPicking(req.lockPicking);
        c.setPoisons(req.poisons);
        c.setTheft(req.theft);
        c.setStealth(req.stealth);
        c.setTrapLore(req.trapLore);

        // Creative
        c.setCreative(req.creative);
        c.setArt(req.art);
        c.setDance(req.dance);
        c.setForging(req.forging);
        c.setMusic(req.music);
        c.setSleightOfHand(req.sleightOfHand);

        return repo.save(c);
    }

    // =====================================================
    // DELETE
    // =====================================================
    public void delete(Long id, Long userId) {
        Character c = getOne(id, userId);
        repo.delete(c);
    }
}
