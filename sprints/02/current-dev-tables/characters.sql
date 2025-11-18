DROP TABLE IF EXISTS characters;

CREATE TABLE characters (
    character_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    creator_id INT UNSIGNED NOT NULL,

    -- Basic character info
    name VARCHAR(100) NOT NULL,
    class VARCHAR(50),
    level INT DEFAULT 1,

    race ENUM(
        "Human",
        "Sylvain",
        "Jayan",
        "D'Anjayni",
        "Ebudan",
        "Daimah",
        "Duk'zarist"
    ) NOT NULL,

    gender VARCHAR(20),
    appearance INT,
    size INT,
    height_cm INT,
    weight_kg INT,
    background TEXT,

    -- Development points spent at character creation
    development_points INT DEFAULT 0,

    -- Primary stats
    str_score INT NOT NULL,
    agi_score INT NOT NULL,
    dex_score INT NOT NULL,
    con_score INT NOT NULL,
    int_score INT NOT NULL,
    per_score INT NOT NULL,
    pow_score INT NOT NULL,
    wp_score INT NOT NULL,

    -- Derived stats
    life_points INT,
    life_point_multiple INT,
    initiative INT,
    fatigue INT,
    attack_base INT,
    defense_base INT,
    movement INT,

    -- ==============================
    -- SECONDARY ABILITIES - ATHLETICS
    -- ==============================
    athletics INT,
    acrobatics INT,
    athleticism INT,
    climb INT,
    jump INT,
    ride INT,
    swim INT,

    -- ==============================
    -- SECONDARY ABILITIES – VIGOR
    -- ==============================
    vigor INT,
    composure INT,
    feats_of_strength INT,
    withstand_pain INT,

    -- ==============================
    -- SECONDARY ABILITIES – PERCEPTION
    -- ==============================
    perception INT,
    notice INT,
    search_skill INT,
    track INT,

    -- ==============================
    -- SECONDARY ABILITIES – INTELLECTUAL
    -- ==============================
    intellectual INT,
    animals INT,
    appraisal INT,
    memorize INT,
    herbal_lore INT,
    history_skill INT,
    magic_appraisal INT,
    medicine INT,
    navigation INT,
    occult INT,
    sciences INT,

    -- ==============================
    -- SECONDARY ABILITIES – SOCIAL
    -- ==============================
    social INT,
    intimidate INT,
    leadership INT,
    persuasion INT,
    style INT,

    -- ==============================
    -- SECONDARY ABILITIES – SUBTERFUGE
    -- ==============================
    subterfuge INT,
    disguise INT,
    hide_skill INT,
    lock_picking INT,
    poisons INT,
    theft INT,
    stealth INT,
    trap_lore INT,

    -- ==============================
    -- SECONDARY ABILITIES – CREATIVE
    -- ==============================
    creative INT,
    art INT,
    dance INT,
    forging INT,
    music INT,
    sleight_of_hand INT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_character_creator
        FOREIGN KEY (creator_id) REFERENCES users(user_id)
        ON DELETE CASCADE
);
