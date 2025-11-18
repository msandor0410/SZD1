package hu.sandor.anima.animabackend.character.dto;

public class CharacterResponse {
    public Long id;
    public String name;
    public String className;
    public Integer level;
    public String race;
    public String gender;
    public String appearance;

    public Integer lifePoints;
    public Integer attackBase;
    public Integer defenseBase;

    public CharacterResponse(Long id, String name, String className, Integer level,
                             String race, String gender, String appearance,
                             Integer lifePoints, Integer attackBase, Integer defenseBase) {

        this.id = id;
        this.name = name;
        this.className = className;
        this.level = level;
        this.race = race;
        this.gender = gender;
        this.appearance = appearance;
        this.lifePoints = lifePoints;
        this.attackBase = attackBase;
        this.defenseBase = defenseBase;
    }
}

