public class Warrior implements Character {
    private String name;
    private int level;
    private double baseHp;
    private double hp;
    private double maxHp;
    private double baseMana;
    private double mana;
    private double maxMana;
    private double baseAttack;
    private double attack;
    private double baseMagic;
    private double magic;
    private double baseDefense;
    private double defense;
    private double baseSpeed;
    private double speed;
    private double maxSpeed;
    private Shield shield;

    public Warrior() {
        this("Sam");
    }

    public Warrior(String name) {
        this(name, 0);
    }

    public Warrior(String name, int level) {
        this(name, 100, 50, 10, 10, 10, 10, level);
    }

    public Warrior(String name, double baseHp, double baseMana, double baseAttack, double baseMagic, double baseDefense, double baseSpeed, int level) {
        this.name = name;
        this.level = level;
        this.baseHp = baseHp;
        this.hp = baseHp + (10 * level);
        this.maxHp = baseHp + (10 * level);
        this.baseMana = baseMana;
        this.mana = baseMana + (2 * level);
        this.maxMana = baseMana + (2 * level);
        this.baseAttack = baseAttack;
        this.attack = baseAttack * (1 + 0.1 * level);
        this.baseMagic = baseMagic;
        this.magic = baseMagic * (1 + 0.1 * level);
        this.baseDefense = baseDefense;
        this.defense = baseDefense * (1 + 2 * level);
        this.baseSpeed = baseSpeed;
        this.speed = baseSpeed + (0.1 + 0.03 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
    }
    
    private void calculateStats() {
        this.maxHp = baseHp + (10 * level);
        this.maxMana = baseMana + (2 * level);
        this.maxSpeed = baseSpeed + (0.1 + 0.03 * level);
        this.attack = baseAttack * (1 + 0.1 * level);
        this.magic = baseMagic * (1 + 0.1 * level);
        this.defense = baseDefense * (1 + 2 * level);
        this.maxSpeed = baseSpeed + (1 + 0.03 * level);
        if (shield != null) {
            speed = maxSpeed * (0.7 + 0.03 * shield.getLevel());
        } else {
            speed = maxSpeed;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public double getMana() {
        return mana;
    }

    public double getMaxMana() {
        return maxMana;
    }

    public double getAttack() {
        return shield == null ? attack : attack + shield.getAttack();
    }

    public double getMagic() {
        return magic;
    }

    public double getDefense() {
        return shield == null ? defense : defense + shield.getDefense();
    }

    public double getSpeed() {
        return speed;
    }

    Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }
    
    public void upgrade() {
        level++;
        calculateStats();
    }

    protected void getAttacked(double damage) {
        damage -= this.getDefense() * 0.5;
        if (damage > 0) {
            hp -= damage;
        }
    }
    
    public void attack(Character target) {
        if (target instanceof Warrior) {
            Warrior warrior = (Warrior) target;
            warrior.getAttacked(this.getAttack());
        } else if (target instanceof Mage) {
            Mage mage = (Mage) target;
            mage.getAttacked(this.getAttack());
        } else if (target instanceof Assassin) {
            Assassin assassin = (Assassin) target;
            assassin.getAttacked(this.getAttack());
        }
    }

    protected void getAttackedMagic(double damage) {
        hp -= damage;
    }

    public void attackMagic(Character target) {
        if (target instanceof Warrior) {
            Warrior warrior = (Warrior) target;
            warrior.getAttackedMagic(this.getMagic());
        } else if (target instanceof Mage) {
            Mage mage = (Mage) target;
            mage.getAttackedMagic(this.getMagic());
        } else if (target instanceof Assassin) {
            Assassin assassin = (Assassin) target;
            assassin.getAttackedMagic(this.getMagic());
        }
    }

    public void heal(double amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public void restoreMana(double amount) {
        mana += amount;
        if (mana > maxMana) {
            mana = maxMana;
        }
    }
}
