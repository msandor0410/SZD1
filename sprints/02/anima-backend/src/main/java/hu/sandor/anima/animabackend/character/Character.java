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

    @Column(name = "class") // fontos: DDL-ben így hívják
    private String className;

    @Column(name = "level")
    private Integer level;

    @Column(name = "race")
    private String race;

    @Column(name = "gender")
    private String gender;

    @Column(name = "appearance")
    private String appearance;

    @Column(name = "height_cm")
    private Integer heightCm;

    @Column(name = "weight_kg")
    private Integer weightKg;

    @Column(name = "background")
    private String background;

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

    @Column(name = "life_points")
    private Integer lifePoints;

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

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
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
}
