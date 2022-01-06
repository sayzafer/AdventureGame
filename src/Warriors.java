public abstract class Warriors {
    private int id;
    private String warriorName;
    private int damage;
    private int health;
    private int coin;

    public Warriors(int id ,String warriorName, int damage, int health, int coin) {
        this.id = id;
        this.warriorName = warriorName;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getWarriorName() {
        return warriorName;
    }

    public void setWarriorName(String warriorName) {
        this.warriorName = warriorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
