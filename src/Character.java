interface Character {
    String name = "Sam";
    int level = 0;
    double baseHp = 100;
    double hp = 100;
    double maxHp = 100;
    double baseMana = 50;
    double mana = 50;
    double maxMana = 50;
    double baseAttack = 10;
    double attack = 10;
    double baseMagic = 10;
    double magic = 10;
    double baseDefense = 10;
    double defense = 10;
    double baseSpeed = 10;
    double speed = 10;
    double maxSpeed = 10;

    default String getName() {
        return name;
    }

    default int getLevel() {
        return level;
    }

    default double getHp() {
        return hp;
    }

    default double getMaxHp() {
        return maxHp;
    }

    default double getMana() {
        return mana;
    }

    default double getMaxMana() {
        return maxMana;
    }

    default double getAttack() {
        return attack;
    }

    default double getMagic() {
        return magic;
    }

    default double getDefense() {
        return defense;
    }

    default double getSpeed() {
        return speed;
    }
    
    void upgrade();
    
    void attack(Character target);

    void attackMagic(Character target);

    void heal(double amount);

    void restoreMana(double amount);
}