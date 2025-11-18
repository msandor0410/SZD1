package hu.sandor.anima.animabackend.character;

import hu.sandor.anima.animabackend.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long characterId;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @Column(name = "name")
    private String name;

    @Column(name = "class")
    private String className;

    @Column(name = "level")
    private Integer level;

    @Column(name = "race")
    private String race;

    @Column(name = "gender")
    private String gender;

    @Column(name = "appearance")
    private Integer appearance;

    @Column(name = "size")
    private Integer size;

    @Column(name = "height_cm")
    private Integer heightCm;

    @Column(name = "weight_kg")
    private Integer weightKg;

    @Column(name = "background")
    private String background;

    @Column(name = "development_points")
    private Integer developmentPoints;

    // Primary
    @Column(name = "str_score")
    private Integer strScore;

    @Column(name = "agi_score")
    private Integer agiScore;

    @Column(name = "dex_score")
    private Integer dexScore;

    @Column(name = "con_score")
    private Integer conScore;

    @Column(name = "int_score")
    private Integer intScore;

    @Column(name = "per_score")
    private Integer perScore;

    @Column(name = "pow_score")
    private Integer powScore;

    @Column(name = "wp_score")
    private Integer wpScore;

    // Derived
    @Column(name = "life_points")
    private Integer lifePoints;

    @Column(name = "life_point_multiple")
    private Integer lifePointMultiple;

    @Column(name = "initiative")
    private Integer initiative;

    @Column(name = "fatigue")
    private Integer fatigue;

    @Column(name = "attack_base")
    private Integer attackBase;

    @Column(name = "defense_base")
    private Integer defenseBase;

    @Column(name = "movement")
    private Integer movement;

    // Athletics
    @Column(name = "athletics")
    private Integer athletics;

    @Column(name = "acrobatics")
    private Integer acrobatics;

    @Column(name = "athleticism")
    private Integer athleticism;

    @Column(name = "climb")
    private Integer climb;

    @Column(name = "jump")
    private Integer jump;

    @Column(name = "ride")
    private Integer ride;

    @Column(name = "swim")
    private Integer swim;

    // Vigor
    @Column(name = "vigor")
    private Integer vigor;

    @Column(name = "composure")
    private Integer composure;

    @Column(name = "feats_of_strength")
    private Integer featsOfStrength;

    @Column(name = "withstand_pain")
    private Integer withstandPain;

    // Perception
    @Column(name = "perception")
    private Integer perception;

    @Column(name = "notice")
    private Integer notice;

    @Column(name = "search_skill")
    private Integer searchSkill;

    @Column(name = "track")
    private Integer track;

    // Intellectual
    @Column(name = "intellectual")
    private Integer intellectual;

    @Column(name = "animals")
    private Integer animals;

    @Column(name = "appraisal")
    private Integer appraisal;

    @Column(name = "memorize")
    private Integer memorize;

    @Column(name = "herbal_lore")
    private Integer herbalLore;

    @Column(name = "history_skill")
    private Integer historySkill;

    @Column(name = "magic_appraisal")
    private Integer magicAppraisal;

    @Column(name = "medicine")
    private Integer medicine;

    @Column(name = "navigation")
    private Integer navigation;

    @Column(name = "occult")
    private Integer occult;

    @Column(name = "sciences")
    private Integer sciences;

    // Social
    @Column(name = "social")
    private Integer social;

    @Column(name = "intimidate")
    private Integer intimidate;

    @Column(name = "leadership")
    private Integer leadership;

    @Column(name = "persuasion")
    private Integer persuasion;

    @Column(name = "style")
    private Integer style;

    // Subterfuge
    @Column(name = "subterfuge")
    private Integer subterfuge;

    @Column(name = "disguise")
    private Integer disguise;

    @Column(name = "hide_skill")
    private Integer hideSkill;

    @Column(name = "lock_picking")
    private Integer lockPicking;

    @Column(name = "poisons")
    private Integer poisons;

    @Column(name = "theft")
    private Integer theft;

    @Column(name = "stealth")
    private Integer stealth;

    @Column(name = "trap_lore")
    private Integer trapLore;

    // Creative
    @Column(name = "creative")
    private Integer creative;

    @Column(name = "art")
    private Integer art;

    @Column(name = "dance")
    private Integer dance;

    @Column(name = "forging")
    private Integer forging;

    @Column(name = "music")
    private Integer music;

    @Column(name = "sleight_of_hand")
    private Integer sleightOfHand;

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAppearance() {
        return appearance;
    }

    public void setAppearance(Integer appearance) {
        this.appearance = appearance;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Integer heightCm) {
        this.heightCm = heightCm;
    }

    public Integer getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getDevelopmentPoints() {
        return developmentPoints;
    }

    public void setDevelopmentPoints(Integer developmentPoints) {
        this.developmentPoints = developmentPoints;
    }

    public Integer getStrScore() {
        return strScore;
    }

    public void setStrScore(Integer strScore) {
        this.strScore = strScore;
    }

    public Integer getAgiScore() {
        return agiScore;
    }

    public void setAgiScore(Integer agiScore) {
        this.agiScore = agiScore;
    }

    public Integer getDexScore() {
        return dexScore;
    }

    public void setDexScore(Integer dexScore) {
        this.dexScore = dexScore;
    }

    public Integer getConScore() {
        return conScore;
    }

    public void setConScore(Integer conScore) {
        this.conScore = conScore;
    }

    public Integer getIntScore() {
        return intScore;
    }

    public void setIntScore(Integer intScore) {
        this.intScore = intScore;
    }

    public Integer getPerScore() {
        return perScore;
    }

    public void setPerScore(Integer perScore) {
        this.perScore = perScore;
    }

    public Integer getPowScore() {
        return powScore;
    }

    public void setPowScore(Integer powScore) {
        this.powScore = powScore;
    }

    public Integer getWpScore() {
        return wpScore;
    }

    public void setWpScore(Integer wpScore) {
        this.wpScore = wpScore;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }

    public Integer getLifePointMultiple() {
        return lifePointMultiple;
    }

    public void setLifePointMultiple(Integer lifePointMultiple) {
        this.lifePointMultiple = lifePointMultiple;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getFatigue() {
        return fatigue;
    }

    public void setFatigue(Integer fatigue) {
        this.fatigue = fatigue;
    }

    public Integer getAttackBase() {
        return attackBase;
    }

    public void setAttackBase(Integer attackBase) {
        this.attackBase = attackBase;
    }

    public Integer getDefenseBase() {
        return defenseBase;
    }

    public void setDefenseBase(Integer defenseBase) {
        this.defenseBase = defenseBase;
    }

    public Integer getMovement() {
        return movement;
    }

    public void setMovement(Integer movement) {
        this.movement = movement;
    }

    public Integer getAthletics() {
        return athletics;
    }

    public void setAthletics(Integer athletics) {
        this.athletics = athletics;
    }

    public Integer getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(Integer acrobatics) {
        this.acrobatics = acrobatics;
    }

    public Integer getAthleticism() {
        return athleticism;
    }

    public void setAthleticism(Integer athleticism) {
        this.athleticism = athleticism;
    }

    public Integer getClimb() {
        return climb;
    }

    public void setClimb(Integer climb) {
        this.climb = climb;
    }

    public Integer getJump() {
        return jump;
    }

    public void setJump(Integer jump) {
        this.jump = jump;
    }

    public Integer getRide() {
        return ride;
    }

    public void setRide(Integer ride) {
        this.ride = ride;
    }

    public Integer getSwim() {
        return swim;
    }

    public void setSwim(Integer swim) {
        this.swim = swim;
    }

    public Integer getVigor() {
        return vigor;
    }

    public void setVigor(Integer vigor) {
        this.vigor = vigor;
    }

    public Integer getComposure() {
        return composure;
    }

    public void setComposure(Integer composure) {
        this.composure = composure;
    }

    public Integer getFeatsOfStrength() {
        return featsOfStrength;
    }

    public void setFeatsOfStrength(Integer featsOfStrength) {
        this.featsOfStrength = featsOfStrength;
    }

    public Integer getWithstandPain() {
        return withstandPain;
    }

    public void setWithstandPain(Integer withstandPain) {
        this.withstandPain = withstandPain;
    }

    public Integer getPerception() {
        return perception;
    }

    public void setPerception(Integer perception) {
        this.perception = perception;
    }

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    public Integer getSearchSkill() {
        return searchSkill;
    }

    public void setSearchSkill(Integer searchSkill) {
        this.searchSkill = searchSkill;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public Integer getIntellectual() {
        return intellectual;
    }

    public void setIntellectual(Integer intellectual) {
        this.intellectual = intellectual;
    }

    public Integer getAnimals() {
        return animals;
    }

    public void setAnimals(Integer animals) {
        this.animals = animals;
    }

    public Integer getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(Integer appraisal) {
        this.appraisal = appraisal;
    }

    public Integer getMemorize() {
        return memorize;
    }

    public void setMemorize(Integer memorize) {
        this.memorize = memorize;
    }

    public Integer getHerbalLore() {
        return herbalLore;
    }

    public void setHerbalLore(Integer herbalLore) {
        this.herbalLore = herbalLore;
    }

    public Integer getHistorySkill() {
        return historySkill;
    }

    public void setHistorySkill(Integer historySkill) {
        this.historySkill = historySkill;
    }

    public Integer getMagicAppraisal() {
        return magicAppraisal;
    }

    public void setMagicAppraisal(Integer magicAppraisal) {
        this.magicAppraisal = magicAppraisal;
    }

    public Integer getMedicine() {
        return medicine;
    }

    public void setMedicine(Integer medicine) {
        this.medicine = medicine;
    }

    public Integer getNavigation() {
        return navigation;
    }

    public void setNavigation(Integer navigation) {
        this.navigation = navigation;
    }

    public Integer getOccult() {
        return occult;
    }

    public void setOccult(Integer occult) {
        this.occult = occult;
    }

    public Integer getSciences() {
        return sciences;
    }

    public void setSciences(Integer sciences) {
        this.sciences = sciences;
    }

    public Integer getSocial() {
        return social;
    }

    public void setSocial(Integer social) {
        this.social = social;
    }

    public Integer getIntimidate() {
        return intimidate;
    }

    public void setIntimidate(Integer intimidate) {
        this.intimidate = intimidate;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public Integer getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(Integer persuasion) {
        this.persuasion = persuasion;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getSubterfuge() {
        return subterfuge;
    }

    public void setSubterfuge(Integer subterfuge) {
        this.subterfuge = subterfuge;
    }

    public Integer getDisguise() {
        return disguise;
    }

    public void setDisguise(Integer disguise) {
        this.disguise = disguise;
    }

    public Integer getHideSkill() {
        return hideSkill;
    }

    public void setHideSkill(Integer hideSkill) {
        this.hideSkill = hideSkill;
    }

    public Integer getLockPicking() {
        return lockPicking;
    }

    public void setLockPicking(Integer lockPicking) {
        this.lockPicking = lockPicking;
    }

    public Integer getPoisons() {
        return poisons;
    }

    public void setPoisons(Integer poisons) {
        this.poisons = poisons;
    }

    public Integer getTheft() {
        return theft;
    }

    public void setTheft(Integer theft) {
        this.theft = theft;
    }

    public Integer getStealth() {
        return stealth;
    }

    public void setStealth(Integer stealth) {
        this.stealth = stealth;
    }

    public Integer getTrapLore() {
        return trapLore;
    }

    public void setTrapLore(Integer trapLore) {
        this.trapLore = trapLore;
    }

    public Integer getCreative() {
        return creative;
    }

    public void setCreative(Integer creative) {
        this.creative = creative;
    }

    public Integer getArt() {
        return art;
    }

    public void setArt(Integer art) {
        this.art = art;
    }

    public Integer getDance() {
        return dance;
    }

    public void setDance(Integer dance) {
        this.dance = dance;
    }

    public Integer getForging() {
        return forging;
    }

    public void setForging(Integer forging) {
        this.forging = forging;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public Integer getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(Integer sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }
}
