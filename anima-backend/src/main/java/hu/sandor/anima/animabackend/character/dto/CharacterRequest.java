package hu.sandor.anima.animabackend.character.dto;

public class CharacterRequest {

    public String name;
    public String className;
    public Integer level;
    public String race;
    public String gender;

    public Integer appearance;
    public Integer size;
    public Integer heightCm;
    public Integer weightKg;
    public String background;

    public Integer developmentPoints;

    // Primary stats
    public Integer strScore;
    public Integer agiScore;
    public Integer dexScore;
    public Integer conScore;
    public Integer intScore;
    public Integer perScore;
    public Integer powScore;
    public Integer wpScore;

    // Derived stats
    public Integer lifePoints;
    public Integer lifePointMultiple;
    public Integer initiative;
    public Integer fatigue;
    public Integer attackBase;
    public Integer defenseBase;
    public Integer movement;

    // Athletics
    public Integer athletics;
    public Integer acrobatics;
    public Integer athleticism;
    public Integer climb;
    public Integer jump;
    public Integer ride;
    public Integer swim;

    // Vigor
    public Integer vigor;
    public Integer composure;
    public Integer featsOfStrength;
    public Integer withstandPain;

    // Perception
    public Integer perception;
    public Integer notice;
    public Integer searchSkill;
    public Integer track;

    // Intellectual
    public Integer intellectual;
    public Integer animals;
    public Integer appraisal;
    public Integer memorize;
    public Integer herbalLore;
    public Integer historySkill;
    public Integer magicAppraisal;
    public Integer medicine;
    public Integer navigation;
    public Integer occult;
    public Integer sciences;

    // Social
    public Integer social;
    public Integer intimidate;
    public Integer leadership;
    public Integer persuasion;
    public Integer style;

    // Subterfuge
    public Integer subterfuge;
    public Integer disguise;
    public Integer hideSkill;
    public Integer lockPicking;
    public Integer poisons;
    public Integer theft;
    public Integer stealth;
    public Integer trapLore;

    // Creative
    public Integer creative;
    public Integer art;
    public Integer dance;
    public Integer forging;
    public Integer music;
    public Integer sleightOfHand;
}
